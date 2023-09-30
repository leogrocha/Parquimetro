package com.techChallenge.parquimetro.condutor.service;

import com.techChallenge.parquimetro.condutor.dto.CondutorFiltroDTO;
import com.techChallenge.parquimetro.condutor.specifications.CondutorFiltro;
import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.condutor.dto.CondutorDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorUpdateDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.endereco.domain.Endereco;
import com.techChallenge.parquimetro.condutor.repository.CondutorRepository;
import com.techChallenge.parquimetro.endereco.repository.EnderecoRepository;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class CondutorService {

    private final CondutorRepository repository;
    private final EnderecoRepository enderecoRepository;
    private final CondutorFiltro condutorFiltro;

    @Transactional(readOnly = true)
    public List<CondutorDTO> findAll(CondutorFiltroDTO condutorFiltroDTO) {
        return repository.findAll(condutorFiltro.aplicarFiltro(condutorFiltroDTO))
                .stream().map(this::convertToResponse).toList();
    }

    @Transactional(readOnly = true)
    public CondutorDTO findById(Long condutorId) {
        return repository.findById(condutorId).stream()
                .map(CondutorDTO::new)
                .findFirst().orElseThrow(() -> new ControllerNotFoundException("Condutor não encontrado."));
    }
    @Transactional
    public CondutorDTO save(CondutorSaveDTO condutorSaveDTO) {
        var endereco = enderecoRepository.save(new Endereco(condutorSaveDTO.getEndereco()));
        var condutor = repository.save(new Condutor(condutorSaveDTO, endereco));
        return new CondutorDTO(condutor);
    }

    @Transactional
    public CondutorDTO update(CondutorUpdateDTO condutorUpdateDTO, Long condutorId) {

        try {

            var condutor = repository.getReferenceById(condutorId);
            var endereco = new Endereco(condutorUpdateDTO.getEndereco());
            endereco.setEnderecoId(condutor.getEndereco().getEnderecoId());
            CondutorUpdateDTO.mapperEntity(condutorUpdateDTO, condutor, endereco);
            endereco = enderecoRepository.save(endereco);
            condutor = repository.save(condutor);
            return new CondutorDTO(condutor);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Condutor não encontrado, id: " + condutorId);
        }

    }

    @Transactional
    public CondutorDTO updateCondutorVeiculo(CondutorUpdateDTO condutorUpdateDTO, Veiculo veiculo, Long condutorId) {

        try {

            var condutor = repository.getReferenceById(condutorId);
            var endereco = new Endereco(condutorUpdateDTO.getEndereco());
            endereco.setEnderecoId(condutor.getEndereco().getEnderecoId());
            CondutorUpdateDTO.mapperEntity(condutorUpdateDTO, condutor, endereco);
            endereco = enderecoRepository.save(endereco);
            condutor.getVeiculos().add(veiculo);
            condutor = repository.save(condutor);
            return new CondutorDTO(condutor);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Condutor não encontrado, id: " + condutorId);
        }

    }

    public CondutorDTO convertToResponse(Condutor condutor) {
        return CondutorDTO.of(condutor);
    }



}
