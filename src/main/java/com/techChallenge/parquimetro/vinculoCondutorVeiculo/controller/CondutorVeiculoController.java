package com.techChallenge.parquimetro.vinculoCondutorVeiculo.controller;

import com.techChallenge.parquimetro.condutor.dto.CondutorDTO;
import com.techChallenge.parquimetro.config.patterns.ResponseApi;
import com.techChallenge.parquimetro.vinculoCondutorVeiculo.service.CondutorVeiculoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associar")
@AllArgsConstructor
public class CondutorVeiculoController {

    private CondutorVeiculoService service;

    @PostMapping
    public ResponseEntity<CondutorDTO> associar(@RequestParam Long condutorId, @RequestParam Long veiculoId) {
        return ResponseEntity.ok(service.associationCondutorVeiculo(condutorId, veiculoId));
    }
}
