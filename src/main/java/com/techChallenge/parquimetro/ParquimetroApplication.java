package com.techChallenge.parquimetro;

import com.techChallenge.parquimetro.registro.dto.RegistroNotificacaoDTO;
import com.techChallenge.parquimetro.registro.projection.RegistroPendentesProjection;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParquimetroApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParquimetroApplication.class, args);
	}

}
