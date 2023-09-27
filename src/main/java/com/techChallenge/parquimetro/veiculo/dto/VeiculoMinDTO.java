package com.techChallenge.parquimetro.veiculo.dto;

import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"veiculoId"})
@ToString
@Getter
@Setter
public class VeiculoMinDTO {

    private Long veiculoId;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String placa;

    public VeiculoMinDTO(Veiculo veiculo) {
        veiculoId = veiculo.getVeiculoId();
        marca = veiculo.getMarca();
        modelo = veiculo.getModelo();
        anoFabricacao = veiculo.getAnoFabricacao();
        placa = veiculo.getPlaca();
    }

}
