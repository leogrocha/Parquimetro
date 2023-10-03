package com.techChallenge.parquimetro.registro.repository;

import com.techChallenge.parquimetro.registro.domain.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
