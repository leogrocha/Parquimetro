package com.techChallenge.parquimetro.dto;

import com.techChallenge.parquimetro.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoSaveDTO {

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

    public EnderecoSaveDTO(Endereco endereco) {
        logradouro=endereco.getLogradouro();
        bairro=endereco.getBairro();
        numero=endereco.getNumero();
        complemento=endereco.getComplemento();
        cep=endereco.getCep();
        municipio=endereco.getMunicipio();
    }


}
