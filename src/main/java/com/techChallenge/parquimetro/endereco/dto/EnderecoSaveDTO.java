package com.techChallenge.parquimetro.endereco.dto;

import com.techChallenge.parquimetro.endereco.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
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

    public static EnderecoSaveDTO of(Endereco endereco) {
        EnderecoSaveDTO enderecoSaveDTO = new EnderecoSaveDTO();
        BeanUtils.copyProperties(endereco, enderecoSaveDTO);
        return enderecoSaveDTO;
    }


}
