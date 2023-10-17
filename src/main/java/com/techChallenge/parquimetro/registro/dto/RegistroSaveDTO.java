package com.techChallenge.parquimetro.registro.dto;


import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.registro.domain.PeriodoEstacionamento;
import com.techChallenge.parquimetro.registro.domain.Registro;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RegistroSaveDTO {

    @NotNull(message = "Período de estacionamento não pode ser nulo.")
    private PeriodoEstacionamento periodoEstacionamento;
    private Integer duracaoDesejada;
    @NotNull(message = "Forma de pagamento não pode ser nula.")
    private FormaPagamento formaPagamento;
    @Positive(message = "tarifa aplicada não pode ser menor do que 0.")
    private BigDecimal tarifaAplicada;
    @NotNull(message = "Condutor não poder ser nulo.")
    private Long condutorId;
    @NotNull(message = "Veículo não poder ser nulo.")
    private Long veiculoId;

    public static RegistroSaveDTO of(Registro registro) {
        RegistroSaveDTO registroSaveDTO = new RegistroSaveDTO();
        BeanUtils.copyProperties(registro, registroSaveDTO);
        return registroSaveDTO;
    }



}
