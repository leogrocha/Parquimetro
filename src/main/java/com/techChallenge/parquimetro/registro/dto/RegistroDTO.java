package com.techChallenge.parquimetro.registro.dto;

import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.condutor.dto.CondutorRegistroDTO;
import com.techChallenge.parquimetro.registro.domain.PeriodoEstacionamento;
import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoMinDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"registroId"})
@ToString
@Getter
@Setter
public class RegistroDTO {

    private Long registroId;
    private PeriodoEstacionamento periodoEstacionamento;
    private Integer duracaoDesejada;
    private FormaPagamento formaPagamento;
    private BigDecimal tarifaAplicada;
    private BigDecimal valorTotal;
    private LocalDateTime inicioRegistro;
    private LocalDateTime dataConclusao;
    private CondutorRegistroDTO condutor;
    private VeiculoMinDTO veiculo;

    public static RegistroDTO of(Registro registro) {
        RegistroDTO registroDTO = new RegistroDTO();
        registroDTO.setCondutor(CondutorRegistroDTO.of(registro.getCondutor()));
        registroDTO.setVeiculo(VeiculoMinDTO.of(registro.getVeiculo()));
        BeanUtils.copyProperties(registro, registroDTO);
        return registroDTO;
    }



}
