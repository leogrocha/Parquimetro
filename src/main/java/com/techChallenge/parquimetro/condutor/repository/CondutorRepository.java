package com.techChallenge.parquimetro.condutor.repository;


import com.techChallenge.parquimetro.condutor.domain.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
