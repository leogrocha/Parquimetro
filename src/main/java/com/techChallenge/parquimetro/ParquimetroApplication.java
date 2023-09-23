package com.techChallenge.parquimetro;

import com.techChallenge.parquimetro.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.dto.EnderecoSaveDTO;
import com.techChallenge.parquimetro.entities.FormaPagamento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParquimetroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParquimetroApplication.class, args);
	}

}
