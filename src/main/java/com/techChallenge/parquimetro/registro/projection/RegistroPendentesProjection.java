package com.techChallenge.parquimetro.registro.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface RegistroPendentesProjection {

    String getNome();
    BigDecimal getValor_total();

    LocalDateTime getInicio_registro();


}
