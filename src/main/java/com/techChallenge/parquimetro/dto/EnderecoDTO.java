package com.techChallenge.parquimetro.dto;

import com.techChallenge.parquimetro.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
