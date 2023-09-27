package com.techChallenge.parquimetro.endereco.dto;

import com.techChallenge.parquimetro.condutor.dto.CondutorMinDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"veiculoId"})
@ToString
@Getter
@Setter
public class VeiculoDTO {

    private Long veiculoId;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String placa;

    private List<CondutorMinDTO> condutores = new ArrayList<>();

    public VeiculoDTO(Veiculo veiculo) {
        veiculoId=veiculo.getVeiculoId();
        marca=veiculo.getMarca();
        modelo=veiculo.getModelo();
        anoFabricacao=veiculo.getAnoFabricacao();
        placa=veiculo.getPlaca();
        for(Condutor condutor: veiculo.getCondutores()) {
            condutores.add(new CondutorMinDTO(condutor));
        }
    }

    public static VeiculoDTO of(Veiculo veiculo) {
        var veiculoDTO = new VeiculoDTO();
        BeanUtils.copyProperties(veiculo, veiculoDTO);
        return veiculoDTO;
    }




}
