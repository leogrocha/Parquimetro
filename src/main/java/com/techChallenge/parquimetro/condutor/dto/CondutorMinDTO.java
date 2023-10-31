package com.techChallenge.parquimetro.condutor.dto;

import com.techChallenge.parquimetro.endereco.dto.EnderecoDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import lombok.*;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"condutorId"})
@ToString
@Getter
@Setter
public class CondutorMinDTO {

    private Long condutorId;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private FormaPagamento formaPagamento;
    private EnderecoDTO endereco;

    public static CondutorMinDTO of(Condutor condutor) {
        CondutorMinDTO condutorMinDTO = new CondutorMinDTO();
        condutorMinDTO.setEndereco(EnderecoDTO.of(condutor.getEndereco()));
        BeanUtils.copyProperties(condutor, condutorMinDTO);
        return condutorMinDTO;
    }
}
