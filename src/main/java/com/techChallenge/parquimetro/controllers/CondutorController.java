package com.techChallenge.parquimetro.controllers;

import com.techChallenge.parquimetro.dto.CondutorDTO;
import com.techChallenge.parquimetro.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.entities.Condutor;
import com.techChallenge.parquimetro.services.CondutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("condutores")
@AllArgsConstructor
public class CondutorController {

    private CondutorService service;

    @GetMapping
    public ResponseEntity<List<CondutorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{condutor_id}")
    public ResponseEntity<CondutorDTO> findById(@PathVariable Long condutor_id) {
        return ResponseEntity.ok(service.findById(condutor_id));
    }

    @PostMapping
    public ResponseEntity<CondutorDTO> save(@RequestBody @Valid CondutorSaveDTO condutorSaveDTO) {
        System.out.println(condutorSaveDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(("/{id}")).toUri();
        return ResponseEntity.created(uri).body(service.save(condutorSaveDTO));
    }


}
