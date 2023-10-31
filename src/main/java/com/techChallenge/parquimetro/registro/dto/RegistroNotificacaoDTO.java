package com.techChallenge.parquimetro.registro.dto;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistroNotificacaoDTO {

    private String message;

    @Override
    public String toString() {
        return message;
    }
}
