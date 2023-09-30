package com.techChallenge.parquimetro.condutor.specifications;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.condutor.dto.CondutorFiltroDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CondutorFiltro {

    public Specification<Condutor> apply(CondutorFiltroDTO condutorFiltroDTO) {
        return Specification
                .where(CondutorSpecifications.byNome(condutorFiltroDTO.getNome()))
                .and(CondutorSpecifications.byCpf(condutorFiltroDTO.getCpf()));

    }
}
