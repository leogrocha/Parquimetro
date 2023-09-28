package com.techChallenge.parquimetro.condutor.dto;

import com.techChallenge.parquimetro.endereco.dto.EnderecoSaveDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CondutorSaveDTO {

    @NotBlank(message = "Nome não pode ser nulo ou em branco")
    private String nome;
    @CPF(message = "CPF inválido")
    @NotBlank(message = "CPF não pode ser nulo ou em branco")
    private String cpf;
    @NotBlank(message = "Telefone não pode ser nulo ou em branco")
    private String telefone;
    @Email(message = "Formato do e-mail inválido")
    @NotBlank(message = "E-mail não pode ser nulo ou em branco")
    private String email;
    @NotNull(message = "Forma de pagamento não pode ser nula.")
    private FormaPagamento formaPagamento;
    @NotNull(message = "Endereço não pode ser nulo")
    private EnderecoSaveDTO endereco;

    public CondutorSaveDTO(Condutor condutor) {
        this(condutor.getNome(), condutor.getCpf(),
                condutor.getTelefone(), condutor.getEmail(),
                condutor.getFormaPagamento(), condutor.getEndereco() != null ? new EnderecoSaveDTO(condutor.getEndereco()) : null);
    }



}
