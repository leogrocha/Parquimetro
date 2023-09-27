package com.techChallenge.parquimetro.veiculo.repository;

import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    
}
