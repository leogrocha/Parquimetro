package com.techChallenge.parquimetro.condutor.dto;

import com.techChallenge.parquimetro.endereco.dto.EnderecoDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoMinDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"condutorId"})
@ToString
@Getter
@Setter
public class CondutorDTO {

    private Long condutorId;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private FormaPagamento formaPagamento;
    private EnderecoDTO endereco;
    private List<VeiculoMinDTO> veiculos = new ArrayList<>();

    public static CondutorDTO of(Condutor condutor) {
        var condutorDTO = new CondutorDTO();
        condutorDTO.setEndereco(EnderecoDTO.of(condutor.getEndereco()));
        List<VeiculoMinDTO> veiculos = new ArrayList<>();
        for (Veiculo veiculo : condutor.getVeiculos()) {
            veiculos.add(VeiculoMinDTO.of(veiculo));
        }
        condutorDTO.setVeiculos(veiculos);
        BeanUtils.copyProperties(condutor, condutorDTO);
        return condutorDTO;
    }
}
