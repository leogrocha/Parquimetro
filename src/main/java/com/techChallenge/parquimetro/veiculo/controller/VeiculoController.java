package com.techChallenge.parquimetro.veiculo.controller;


import com.techChallenge.parquimetro.endereco.dto.VeiculoDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoFiltroDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoSaveDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoUpdateDTO;
import com.techChallenge.parquimetro.veiculo.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("veiculos")
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoService service;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll(VeiculoFiltroDTO veiculoFiltroDTO) {
        return ResponseEntity.ok(service.findAll(veiculoFiltroDTO));
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long veiculoId) {
        return ResponseEntity.ok(service.findById(veiculoId));
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> save(@RequestBody @Valid VeiculoSaveDTO veiculoSaveDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(("/{id}")).toUri();
        return ResponseEntity.created(uri).body(service.save(veiculoSaveDTO));
    }

    @PutMapping("/{veiculoId}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long veiculoId, @Valid @RequestBody VeiculoUpdateDTO veiculoUpdateDTO) {
        return ResponseEntity.ok(service.update(veiculoUpdateDTO, veiculoId));
    }

}
