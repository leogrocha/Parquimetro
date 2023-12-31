package com.techChallenge.parquimetro.condutor.controller;

import com.techChallenge.parquimetro.condutor.dto.CondutorDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorFiltroDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorUpdateDTO;
import com.techChallenge.parquimetro.condutor.service.CondutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("condutores")
@AllArgsConstructor
public class CondutorController {

    private final CondutorService service;

    @GetMapping
    public ResponseEntity<List<CondutorDTO>> findAll(CondutorFiltroDTO condutorFiltroDTO) {
        return ResponseEntity.ok(service.findAll(condutorFiltroDTO));
    }

    @GetMapping("/{condutor_id}")
    public ResponseEntity<CondutorDTO> findById(@PathVariable Long condutor_id) {
        return ResponseEntity.ok(service.findById(condutor_id));
    }

    @PostMapping
    public ResponseEntity<CondutorDTO> save(@Valid @RequestBody CondutorSaveDTO condutorSaveDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(("/{id}")).toUri();
        return ResponseEntity.created(uri).body(service.save(condutorSaveDTO));
    }

    @PutMapping("/{condutorId}")
    public ResponseEntity<CondutorDTO> update(@Valid @RequestBody CondutorUpdateDTO condutorUpdateDTO, @PathVariable Long condutorId) {
        return ResponseEntity.ok(service.update(condutorUpdateDTO, condutorId));
    }


}
