package com.techChallenge.parquimetro.condutor.dto;

import com.techChallenge.parquimetro.endereco.dto.EnderecoUpdateDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.endereco.domain.Endereco;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"condutorId"})
@ToString
@Getter
@Setter
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
    @Valid private EnderecoUpdateDTO endereco;

    public static CondutorUpdateDTO of(Condutor condutor) {
        CondutorUpdateDTO condutorUpdateDTO = new CondutorUpdateDTO();
        condutorUpdateDTO.setEndereco(EnderecoUpdateDTO.of(condutor.getEndereco()));
        BeanUtils.copyProperties(condutor, condutorUpdateDTO);
        return condutorUpdateDTO;
    }

    public static void mapperEntity(CondutorUpdateDTO condutorUpdateDTO, Condutor condutor, Endereco endereco) {
        condutor.setNome(condutorUpdateDTO.getNome());
        condutor.setTelefone(condutorUpdateDTO.getTelefone());
        condutor.setEmail(condutorUpdateDTO.getEmail());
        condutor.setFormaPagamento(condutorUpdateDTO.getFormaPagamento());
        condutor.setEndereco(endereco);
    }
}
