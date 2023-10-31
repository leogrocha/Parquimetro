package com.techChallenge.parquimetro.veiculo.specification;

import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import org.springframework.data.jpa.domain.Specification;

public class VeiculoSpecifications {


    public static Specification<Veiculo> byPlaca(String placa) {
        return (root, query, criteriaBuilder)
                -> placa == null ? null : criteriaBuilder.like(root.get("placa"), "%" + placa + "%");
    }
}
