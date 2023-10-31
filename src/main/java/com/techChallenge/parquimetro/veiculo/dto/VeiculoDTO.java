package com.techChallenge.parquimetro.veiculo.dto;

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

    public static VeiculoDTO of(Veiculo veiculo) {
        var veiculoDTO = new VeiculoDTO();
        List<CondutorMinDTO> condutores = new ArrayList<>();
        for (Condutor condutor : veiculo.getCondutores()) {
            condutores.add(CondutorMinDTO.of(condutor));
        }
        veiculoDTO.setCondutores(condutores);
        BeanUtils.copyProperties(veiculo, veiculoDTO);
        List<CondutorMinDTO> listaCondutores = new ArrayList<>();
        return veiculoDTO;
    }




}
