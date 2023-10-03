package com.techChallenge.parquimetro.registro.domain;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.domain.FormaPagamento;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_registro")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"registroId"})
@ToString
@Getter
@Setter
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registroId;
    @Enumerated(EnumType.STRING)
    private PeriodoEstacionamento periodoEstacionamento;
    private Integer duracaoDesejada;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    private BigDecimal tarifaAplicada;
    private BigDecimal valorTotal;
    private LocalDateTime inicioRegistro;
    private LocalDateTime dataConclusao;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "condutor_id", nullable = false)
    private Condutor condutor;

}
