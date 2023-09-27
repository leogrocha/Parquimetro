package com.techChallenge.parquimetro.condutor.dto;

import com.techChallenge.parquimetro.endereco.dto.EnderecoDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import lombok.*;

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

    public CondutorMinDTO(Condutor condutor) {
        condutorId = condutor.getCondutorId();
        nome = condutor.getNome();
        cpf = condutor.getCpf();
        telefone = condutor.getTelefone();
        email = condutor.getEmail();
        formaPagamento = condutor.getFormaPagamento();
        endereco = new EnderecoDTO(condutor.getEndereco());
    }
}
