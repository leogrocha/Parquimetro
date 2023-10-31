package com.techChallenge.parquimetro.condutor.domain;

import com.techChallenge.parquimetro.config.exceptions.DatabaseException;
import com.techChallenge.parquimetro.registro.domain.PeriodoEstacionamento;

public enum FormaPagamento {

    PIX, CARTAO_CREDITO, CARTAO_DEBITO;

    public static void formaPagamentoPixEPeriodoEstacionamentoPorHora(PeriodoEstacionamento periodoEstacionamento, FormaPagamento formaPagamento) {
        if(periodoEstacionamento == PeriodoEstacionamento.POR_HORA && formaPagamento == FormaPagamento.PIX) {
            throw new DatabaseException("Caso período de estacionamento seja por hora não poderá ser selecionado opção de pagamento por PIX.");
        }
    }


}
