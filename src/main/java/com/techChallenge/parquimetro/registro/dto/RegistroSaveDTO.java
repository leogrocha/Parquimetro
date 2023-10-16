package com.techChallenge.parquimetro.registro.dto;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.condutor.dto.CondutorRegistroDTO;
import com.techChallenge.parquimetro.registro.domain.PeriodoEstacionamento;
import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoMinDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RegistroSaveDTO {

    private PeriodoEstacionamento periodoEstacionamento;
    private Integer duracaoDesejada;
    private FormaPagamento formaPagamento;
    private BigDecimal tarifaAplicada;
    private BigDecimal valorTotal;
    private LocalDateTime inicioRegistro;
    private LocalDateTime fimRegistro;
    private Long condutorId;
    private Long veiculoId;

    public static RegistroSaveDTO of(Registro registro) {
        RegistroSaveDTO registroSaveDTO = new RegistroSaveDTO();
        BeanUtils.copyProperties(registro, registroSaveDTO);
        return registroSaveDTO;
    }



}
