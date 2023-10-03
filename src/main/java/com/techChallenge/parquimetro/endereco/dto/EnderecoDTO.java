package com.techChallenge.parquimetro.endereco.dto;

import com.techChallenge.parquimetro.endereco.domain.Endereco;
import lombok.*;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enderecoId"})
@ToString
@Getter
@Setter
public class EnderecoDTO{

    private Long enderecoId;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String municipio;

    public static EnderecoDTO of(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        BeanUtils.copyProperties(endereco, enderecoDTO);
        return enderecoDTO;
    }

    public static EnderecoDTO ofUpdate(EnderecoUpdateDTO enderecoUpdateDTO) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        BeanUtils.copyProperties(enderecoUpdateDTO, enderecoDTO);
        return enderecoDTO;
    }
}
