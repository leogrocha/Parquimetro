package com.techChallenge.parquimetro.dto;

import com.techChallenge.parquimetro.entities.Condutor;
import com.techChallenge.parquimetro.entities.Endereco;
import com.techChallenge.parquimetro.entities.FormaPagamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondutorSaveDTO {

    @NotBlank(message = "Nome não pode ser nulo ou em branco")
    private String nome;
    @CPF(message = "Formato do CPF inválido")
    @NotBlank(message = "CPF não pode ser nulo ou em branco")
    private String cpf;
    @NotBlank(message = "Telefone não pode ser nulo ou em branco")
    private String telefone;
    @Email(message = "Formato do e-mail inválido")
    @NotBlank(message = "E-mail não pode ser nulo ou em branco")
    private String email;
    private FormaPagamento formaPagamento;
    @NotNull(message = "Endereço não pode ser nulo")
    private EnderecoSaveDTO endereco;

    public CondutorSaveDTO(Condutor condutor) {
        this(condutor.getNome(), condutor.getCpf(),
                condutor.getTelefone(), condutor.getEmail(),
                condutor.getFormaPagamento(), condutor.getEndereco() != null ? new EnderecoSaveDTO(condutor.getEndereco()) : null);
    }



}
