package com.techChallenge.parquimetro.veiculo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class VeiculoUpdateDTO {

    @NotBlank(message = "Marca não pode ser nulo ou em branco.")
    private String marca;
    @NotBlank(message = "Modelo não pode ser nulo ou em branco.")
    private String modelo;
    @NotNull(message = "Ano de fabricação não pode ser nulo.")
    @Positive(message = "Ano de fabricação não pode ser negativo")
    private Integer anoFabricacao;
    @NotBlank(message = "Placa não pode ser nulo ou em branco.")
    private String placa;


}
