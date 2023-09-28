package com.techChallenge.parquimetro.config.patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {

    private boolean success;
    private String message;
}
