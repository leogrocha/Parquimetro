package com.techChallenge.parquimetro.veiculo.domain;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoSaveDTO;
import com.techChallenge.parquimetro.veiculo.dto.VeiculoUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_veiculo")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"veiculoId"})
@ToString
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long veiculoId;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    @Column(unique = true)
    private String placa;

    @ManyToMany(mappedBy = "veiculos")
    @Setter(AccessLevel.NONE)
    private Set<Condutor> condutores = new HashSet<>();

    @OneToMany(mappedBy = "veiculo")
    private Set<Registro> registros = new HashSet<>();

    public static Veiculo ofSave(VeiculoSaveDTO veiculoSaveDTO) {
        var veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoSaveDTO, veiculo);
        return veiculo;
    }

    public static Veiculo ofUpdate(VeiculoUpdateDTO veiculoUpdateDTO, Long veiculoId) {
        var veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoUpdateDTO, veiculo);
        veiculo.setVeiculoId(veiculoId);
        return veiculo;
    }


}
