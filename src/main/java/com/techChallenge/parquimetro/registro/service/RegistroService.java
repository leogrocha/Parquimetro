package com.techChallenge.parquimetro.registro.service;

import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistroService {

    private final RegistroRepository repository;

    @Transactional(readOnly = true)
    public List<RegistroDTO> findAll() {
        return repository.findAll().stream().map(RegistroDTO::of).toList();
    }
}
