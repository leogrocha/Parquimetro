package com.techChallenge.parquimetro.config.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String message) {
        super(message);
    }
}
