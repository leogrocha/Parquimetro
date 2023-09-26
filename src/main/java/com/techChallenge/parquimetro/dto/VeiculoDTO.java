package com.techChallenge.parquimetro.dto;

import com.techChallenge.parquimetro.entities.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    private Long veiculoId;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String placa;




}
