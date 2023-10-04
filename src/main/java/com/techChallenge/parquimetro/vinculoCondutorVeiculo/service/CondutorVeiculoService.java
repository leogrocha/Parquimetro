package com.techChallenge.parquimetro.vinculoCondutorVeiculo.service;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.dto.CondutorDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorUpdateDTO;
import com.techChallenge.parquimetro.condutor.repository.CondutorRepository;
import com.techChallenge.parquimetro.condutor.service.CondutorService;
import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.config.exceptions.DatabaseException;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import com.techChallenge.parquimetro.veiculo.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CondutorVeiculoService {

    private CondutorRepository condutorRepository;
    private VeiculoRepository veiculoRepository;
    private CondutorService condutorService;

    @Transactional
    public CondutorDTO associationCondutorVeiculo(Long condutorId, Long veiculoId) {

        var condutor = condutorRepository.findById(condutorId)
                .orElseThrow(() -> new ControllerNotFoundException("Condutor não encontrado."));
        var veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new ControllerNotFoundException("Veiculo não encontrado"));

        if(condutor.getVeiculos().contains(veiculo)) {
            throw new DatabaseException("Veículo já está vinculado ao condutor");
        }

        condutor.getVeiculos().add(veiculo);
        return condutorService.updateCondutorVeiculo(CondutorUpdateDTO.of(condutor), veiculo, condutorId);
    }

    public void validarSeCondutorEVeiculoEstaoVinculados(Condutor condutor, Veiculo veiculo) {
        condutor.getVeiculos().stream()
                .filter(veiculoFilter -> veiculoFilter == veiculo)
                .findFirst().orElseThrow(() ->
                        new DatabaseException("Condutor e veículo não vinculados"));

    }
}
