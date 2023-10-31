package com.techChallenge.parquimetro.registro.controller;

import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.dto.RegistroSaveDTO;
import com.techChallenge.parquimetro.registro.service.RegistroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{registroId}")
    public ResponseEntity<RegistroDTO> findById(@PathVariable Long registroId) {
        return ResponseEntity.ok(service.findById(registroId));
    }

    @PostMapping
    public ResponseEntity<RegistroDTO> save(@Valid @RequestBody RegistroSaveDTO registroSaveDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(("/{id}")).toUri();
        return ResponseEntity.created(uri).body(service.save(registroSaveDTO));
    }

    @PutMapping("finish/{registroId}")
    public ResponseEntity<RegistroDTO> finishRegister(@PathVariable Long registroId) {
        return ResponseEntity.ok(service.finishRegister(registroId));
    }
}
