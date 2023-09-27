package com.techChallenge.parquimetro.endereco.repository;


import com.techChallenge.parquimetro.endereco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
