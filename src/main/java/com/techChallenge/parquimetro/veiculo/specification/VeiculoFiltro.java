package com.techChallenge.parquimetro.veiculo.specification;

import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoFiltroDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
@Component
public class VeiculoFiltro {

    public Specification<Veiculo> aplicarFiltro(VeiculoFiltroDTO veiculoFiltroDTO) {
        return Specification
                .where(VeiculoSpecifications.byPlaca(veiculoFiltroDTO.getPlaca()));
    }
}
