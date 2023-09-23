package com.techChallenge.parquimetro.config;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String message) {
        super(message);
    }
}
