package com.techChallenge.parquimetro.condutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CondutorFiltroDTO {

    private String nome;
    private String cpf;
}
