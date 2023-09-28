package com.techChallenge.parquimetro.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {

    private String fielName;
    private String message;
}
