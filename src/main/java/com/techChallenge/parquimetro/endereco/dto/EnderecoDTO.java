package com.techChallenge.parquimetro.endereco.dto;

import com.techChallenge.parquimetro.endereco.domain.Endereco;
import lombok.*;

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

    public EnderecoDTO(Endereco endereco) {
        this(endereco.getEnderecoId(), endereco.getLogradouro(), endereco.getBairro(),
                endereco.getNumero(), endereco.getComplemento(), endereco.getCep(),
                endereco.getMunicipio());
    }

    public EnderecoDTO(EnderecoUpdateDTO enderecoUpdateDTO) {
        enderecoId=enderecoUpdateDTO.getEnderecoId();
        logradouro=enderecoUpdateDTO.getLogradouro();
        bairro=enderecoUpdateDTO.getBairro();
        numero=enderecoUpdateDTO.getNumero();
        complemento=enderecoUpdateDTO.getComplemento();
        cep=enderecoUpdateDTO.getCep();
        municipio=enderecoUpdateDTO.getMunicipio();
    }
}
