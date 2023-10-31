package com.techChallenge.parquimetro.condutor.domain;

import com.techChallenge.parquimetro.condutor.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorUpdateDTO;
import com.techChallenge.parquimetro.endereco.domain.Endereco;
import com.techChallenge.parquimetro.endereco.dto.EnderecoSaveDTO;
import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_condutor")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"condutorId"})
@ToString
@Getter
@Setter
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long condutorId;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String telefone;
    private String email;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
            name = "tb_condutor_veiculo",
            joinColumns = @JoinColumn(name = "condutor_id"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_id")
    )
    private Set<Veiculo> veiculos = new HashSet<>();

    @OneToMany(mappedBy = "condutor")
    private Set<Registro> registros = new HashSet<>();

    public static Condutor ofSave(CondutorSaveDTO condutorSaveDTO, Endereco endereco) {
        Condutor condutor = new Condutor();
        condutor.setEndereco(endereco);
        BeanUtils.copyProperties(condutorSaveDTO, condutor);
        return condutor;
    }

    public static Condutor ofUpdate(CondutorUpdateDTO condutorUpdateDTO) {
        Condutor condutor = new Condutor();
        condutor.setEndereco(Endereco.ofUpdate(condutorUpdateDTO.getEndereco()));
        BeanUtils.copyProperties(condutorUpdateDTO, condutor);
        return condutor;
    }

}
