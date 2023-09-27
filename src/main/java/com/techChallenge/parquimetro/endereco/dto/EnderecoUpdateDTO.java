package com.techChallenge.parquimetro.endereco.dto;

import com.techChallenge.parquimetro.endereco.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enderecoId"})
@ToString
@Getter
@Setter
public class EnderecoUpdateDTO {

    Long enderecoId;

    @NotBlank(message = "Logradouro não pode ser nulo ou em branco")
    private String logradouro;
    @NotBlank(message = "Bairro não pode ser nulo ou em branco")
    private String bairro;
    @NotBlank(message = "Número não pode ser nulo ou em branco")
    private String numero;
    private String complemento;
    @NotBlank(message = "CEP não pode ser nulo ou em branco")
    private String cep;
    @NotBlank(message = "Município não pode ser nulo ou em branco")
    private String municipio;

    public EnderecoUpdateDTO(Endereco endereco) {
        this(endereco.getEnderecoId(),
                endereco.getLogradouro(), endereco.getBairro(),
                endereco.getNumero(), endereco.getComplemento(),
                endereco.getCep(), endereco.getMunicipio());
    }
}
