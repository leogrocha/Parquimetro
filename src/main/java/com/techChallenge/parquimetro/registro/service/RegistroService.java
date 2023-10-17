package com.techChallenge.parquimetro.registro.service;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.condutor.repository.CondutorRepository;
import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.registro.domain.PeriodoEstacionamento;
import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.dto.RegistroSaveDTO;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import com.techChallenge.parquimetro.registro.service.notifications.NotificacaoPorHora;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import com.techChallenge.parquimetro.veiculo.repository.VeiculoRepository;
import com.techChallenge.parquimetro.condutorVeiculo.service.CondutorVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistroService {

    private final RegistroRepository repository;
    private final CondutorRepository condutorRepository;
    private final VeiculoRepository veiculoRepository;
    private final CondutorVeiculoService condutorVeiculoService;

    private final NotificacaoPorHora notificacaoPorHora;

    @Transactional(readOnly = true)
    public List<RegistroDTO> findAll() {
        return repository.findAll().stream().map(RegistroDTO::of).toList();
    }

    @Transactional(readOnly = true)
    public RegistroDTO findById(Long registroId) {
        return repository.findById(registroId)
                .stream().map(RegistroDTO::of).findFirst()
                .orElseThrow(() -> new ControllerNotFoundException("Registro não encontrado. ID: " + registroId));
    }

    @Transactional
    public RegistroDTO save(RegistroSaveDTO registroSaveDTO) {
        var condutor = condutorRepository.findById(registroSaveDTO.getCondutorId())
                .orElseThrow(() -> new ControllerNotFoundException("Condutor não encontrado."));
        var veiculo = veiculoRepository.findById(registroSaveDTO.getVeiculoId())
                .orElseThrow(() -> new ControllerNotFoundException("Veículo não encontrado."));

        condutorVeiculoService.validarSeCondutorEVeiculoEstaoVinculados(condutor, veiculo);
        FormaPagamento.formaPagamentoPixEPeriodoEstacionamentoPorHora(registroSaveDTO.getPeriodoEstacionamento(), registroSaveDTO.getFormaPagamento());
        validacaoDuracaoDesejadaComPeriodoFixo(registroSaveDTO.getPeriodoEstacionamento(), registroSaveDTO.getDuracaoDesejada());
        var registro = repository.save(Registro.ofSave(registroSaveDTO, condutor, veiculo));
        if(registroSaveDTO.getPeriodoEstacionamento() == PeriodoEstacionamento.POR_HORA) {
            notificacaoPorHora.enviarNotificacaoPorHora(registro.getRegistroId());
        }
        return RegistroDTO.of(registro);
    }

    @Transactional
    public RegistroDTO finishRegister(Long registroId) {
        var registro = repository.findById(registroId)
                .orElseThrow(() -> new ControllerNotFoundException("Registro não encontrado."));
        registro.setFimRegistro(LocalDateTime.now());
        repository.save(registro);
        return RegistroDTO.of(registro);
    }

    public void validacaoDuracaoDesejadaComPeriodoFixo(PeriodoEstacionamento periodoEstacionamento, Integer duracaoDesejada) {
        if(duracaoDesejada == null && periodoEstacionamento == PeriodoEstacionamento.FIXO)
            throw new IllegalArgumentException("Duração não poder ser nula.");
    }






}
