package com.techChallenge.parquimetro.dto;

import com.techChallenge.parquimetro.entities.Condutor;
import com.techChallenge.parquimetro.entities.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondutorUpdateDTO {

    private String nome;
    private String telefone;
    private String email;
    private FormaPagamento formaPagamento;
    private EnderecoDTO endereco;

    public CondutorUpdateDTO(Condutor condutor) {
        this(condutor.getNome(), condutor.getTelefone(), condutor.getEmail(), condutor.getFormaPagamento(), new EnderecoDTO(condutor.getEndereco()));
    }
}
