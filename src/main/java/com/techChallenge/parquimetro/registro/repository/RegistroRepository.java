package com.techChallenge.parquimetro.registro.repository;

import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.projection.RegistroPendentesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    @Query(nativeQuery = true, value = "SELECT tbc.nome, tbr.valor_total FROM tb_registro tbr\n" +
            "inner join tb_condutor tbc ON tbr.condutor_id  = tbc.condutor_id\n" +
            " where tbr.fim_registro is null")
    List<RegistroPendentesProjection> findAllByFimRegistroNull();
}
