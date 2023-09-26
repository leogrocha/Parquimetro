package com.techChallenge.parquimetro.dto;

import com.techChallenge.parquimetro.entities.Condutor;
import com.techChallenge.parquimetro.entities.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondutorDTO {

    private Long condutorId;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private FormaPagamento formaPagamento;
    private EnderecoDTO endereco;

    public CondutorDTO(Condutor condutor) {
        this(condutor.getCondutorId(), condutor.getNome(), condutor.getCpf(), condutor.getTelefone(), condutor.getEmail(), condutor.getFormaPagamento(), new EnderecoDTO(condutor.getEndereco()));
    }

}
