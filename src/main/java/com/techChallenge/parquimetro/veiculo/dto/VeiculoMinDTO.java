package com.techChallenge.parquimetro.veiculo.dto;

import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import lombok.*;
import org.springframework.beans.BeanUtils;


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
    public static VeiculoMinDTO of(Veiculo veiculo) {
        VeiculoMinDTO veiculoMinDTO = new VeiculoMinDTO();
        BeanUtils.copyProperties(veiculo, veiculoMinDTO);
        return veiculoMinDTO;
    }

}
