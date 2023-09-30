package com.techChallenge.parquimetro.condutor.specifications;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import org.springframework.data.jpa.domain.Specification;

public class CondutorSpecifications {

    public static Specification<Condutor> byNome (String nome) {
        return (root, consulta, criterio) -> nome == null
                ? null : criterio.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Condutor> byCpf (String cpf) {
        return (root, consulta, criterio) -> cpf == null
                ? null : criterio.like(root.get("cpf"), "%" + cpf + "%");
    }
}
