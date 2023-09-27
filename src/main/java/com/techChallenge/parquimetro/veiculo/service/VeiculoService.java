package com.techChallenge.parquimetro.veiculo.service;

import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.endereco.dto.VeiculoDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoSaveDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoUpdateDTO;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import com.techChallenge.parquimetro.veiculo.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VeiculoService {

    private VeiculoRepository repository;

    @Transactional(readOnly = true)
    public List<VeiculoDTO> findAll() {
        return repository.findAll().stream().map(VeiculoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public VeiculoDTO findById(Long veiculoId) {
        return repository.findById(veiculoId)
                .stream().map(VeiculoDTO::new).findFirst()
                .orElseThrow(() -> new ControllerNotFoundException("Veículo não encontrado"));
    }

    @Transactional
    public VeiculoDTO save(VeiculoSaveDTO veiculoSaveDTO) {
        var veiculo = Veiculo.ofSave(veiculoSaveDTO);
        repository.save(veiculo);
        return VeiculoDTO.of(veiculo);
    }

    @Transactional
    public VeiculoDTO update(VeiculoUpdateDTO veiculoUpdateDTO, Long veiculoId) {
        var veiculo = Veiculo.ofUpdate(veiculoUpdateDTO, veiculoId);
        repository.save(veiculo);
        return VeiculoDTO.of(veiculo);
    }







}
