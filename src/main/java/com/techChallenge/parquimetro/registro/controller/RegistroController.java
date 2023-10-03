package com.techChallenge.parquimetro.registro.controller;

import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.service.RegistroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registros")
@AllArgsConstructor
public class RegistroController {

    private final RegistroService service;

    @GetMapping
    public ResponseEntity<List<RegistroDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
