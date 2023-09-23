package com.techChallenge.parquimetro.repositories;


import com.techChallenge.parquimetro.entities.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
