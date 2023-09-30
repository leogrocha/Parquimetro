package com.techChallenge.parquimetro.condutor.specifications;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import org.springframework.data.jpa.domain.Specification;

public class CondutorSpecifications {

    public static Specification<Condutor> byNome(String nome) {
        return (root, query, criteriaBuilder)
                -> nome == null ? null : criteriaBuilder.like(root.get("placa"), "%" + nome + "%");
    }

    public static Specification<Condutor> byCpf(String cpf) {
        return (root, query, criteriaBuilder)
                -> cpf == null ? null : criteriaBuilder.like(root.get("cpf"), "%" + cpf + "%");
    }




}
