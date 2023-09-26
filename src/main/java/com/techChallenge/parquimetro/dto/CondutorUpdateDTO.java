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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondutorUpdateDTO {

    Long condutorId;

    @NotBlank(message = "Nome não pode ser nulo ou em branco")
    private String nome;
    @NotBlank(message = "Telefone não pode ser nulo ou em branco")
    private String telefone;
    @Email(message = "Formato do e-mail inválido")
    @NotBlank(message = "E-mail não pode ser nulo ou em branco")
    private String email;
    private FormaPagamento formaPagamento;
    @NotNull(message = "Endereço não pode ser nulo")
    private EnderecoUpdateDTO endereco;

    public CondutorUpdateDTO(Condutor condutor) {
                this(condutor.getCondutorId(),
                condutor.getNome(),
                condutor.getTelefone(),
                condutor.getEmail(),
                condutor.getFormaPagamento(),
                condutor.getEndereco() != null ? new EnderecoUpdateDTO(condutor.getEndereco()) : null);
    }

    public static void mapperEntity(CondutorUpdateDTO condutorUpdateDTO, Condutor condutor, Endereco endereco) {
        condutor.setNome(condutorUpdateDTO.getNome());
        condutor.setTelefone(condutorUpdateDTO.getTelefone());
        condutor.setEmail(condutorUpdateDTO.getEmail());
        condutor.setFormaPagamento(condutorUpdateDTO.getFormaPagamento());
        condutor.setEndereco(endereco);
    }
}
