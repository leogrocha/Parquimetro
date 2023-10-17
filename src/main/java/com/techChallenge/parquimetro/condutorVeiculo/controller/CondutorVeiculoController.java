package com.techChallenge.parquimetro.condutorVeiculo.controller;

import com.techChallenge.parquimetro.condutor.dto.CondutorDTO;
import com.techChallenge.parquimetro.condutorVeiculo.service.CondutorVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class CondutorVeiculoController {

    private CondutorVeiculoService service;

    @PostMapping("/associar")
    public ResponseEntity<CondutorDTO> associar(@RequestParam Long condutorId, @RequestParam Long veiculoId) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(("/{id}")).toUri();
        return ResponseEntity.created(uri).body(service.associationCondutorVeiculo(condutorId, veiculoId));
    }

    @DeleteMapping("/desvincular")
    public ResponseEntity<CondutorDTO> desvincular(@RequestParam Long condutorId, @RequestParam Long veiculoId) {
        service.desvincularCondutorEVeiculo(condutorId, veiculoId);
        return ResponseEntity.noContent().build();
    }
}
