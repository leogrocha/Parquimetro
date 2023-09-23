package com.techChallenge.parquimetro.services;

import com.techChallenge.parquimetro.config.ControllerNotFoundException;
import com.techChallenge.parquimetro.dto.CondutorDTO;
import com.techChallenge.parquimetro.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.entities.Condutor;
import com.techChallenge.parquimetro.entities.Endereco;
import com.techChallenge.parquimetro.repositories.CondutorRepository;
import com.techChallenge.parquimetro.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;


@Service
@AllArgsConstructor
public class CondutorService {

    private CondutorRepository repository;
    private EnderecoRepository enderecoRepository;


    @Transactional(readOnly = true)
    public List<CondutorDTO> findAll() {
        return repository.findAll().stream().map(CondutorDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CondutorDTO findById(Long condutor_id) {
        return repository.findById(condutor_id).stream()
                .map(CondutorDTO::new)
                .findFirst().orElseThrow(() -> new ControllerNotFoundException("Condutor não encontrado."));
    }

    @Transactional
    public CondutorDTO save(CondutorSaveDTO condutorSaveDTO) {
        var endereco = enderecoRepository.save(new Endereco(condutorSaveDTO.getEndereco()));
        var condutor = repository.save(new Condutor(condutorSaveDTO, endereco));
        return new CondutorDTO(condutor);
    }


}
