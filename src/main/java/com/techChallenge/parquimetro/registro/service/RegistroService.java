package com.techChallenge.parquimetro.registro.service;

import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.condutor.repository.CondutorRepository;
import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.dto.RegistroSaveDTO;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import com.techChallenge.parquimetro.registro.service.notificacoes.NotificacaoPorHora;
import com.techChallenge.parquimetro.veiculo.repository.VeiculoRepository;
import com.techChallenge.parquimetro.condutorVeiculo.service.CondutorVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        var condutor = condutorRepository.getReferenceById(registroSaveDTO.getCondutorId());
        var veiculo = veiculoRepository.getReferenceById(registroSaveDTO.getVeiculoId());

        condutorVeiculoService.validarSeCondutorEVeiculoEstaoVinculados(condutor, veiculo);
        FormaPagamento.formaPagamentoPixEPeriodoEstacionamentoPorHora(registroSaveDTO.getPeriodoEstacionamento(), registroSaveDTO.getFormaPagamento());
        var registro = repository.save(Registro.ofSave(registroSaveDTO, condutor, veiculo));
        notificacaoPorHora.enviarNotificacao(registro);
        return RegistroDTO.of(registro);
    }






}
