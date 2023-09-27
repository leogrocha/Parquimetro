package com.techChallenge.parquimetro.condutor.domain;

import com.techChallenge.parquimetro.condutor.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorUpdateDTO;
import com.techChallenge.parquimetro.endereco.domain.Endereco;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import jakarta.persistence.*;
import lombok.*;

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
    private String cpf;
    private String telefone;
    private String email;
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

    public Condutor(CondutorSaveDTO dto) {
        nome = dto.getNome();
        cpf = dto.getCpf();
        telefone = dto.getTelefone();
        email = dto.getEmail();
        formaPagamento = dto.getFormaPagamento();
    }

    public Condutor(CondutorSaveDTO condutorDTO, Endereco endereco) {
        nome=condutorDTO.getNome();
        cpf=condutorDTO.getCpf();
        telefone=condutorDTO.getTelefone();
        email=condutorDTO.getEmail();
        formaPagamento=condutorDTO.getFormaPagamento();
        this.endereco = endereco;
    }

    public Condutor(String nome, String cpf, String telefone, String email, FormaPagamento formaPagamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.formaPagamento = formaPagamento;
    }

    public Condutor(CondutorUpdateDTO condutorUpdateDTO, Endereco endereco) {
        nome=condutorUpdateDTO.getNome() != null ? condutorUpdateDTO.getNome() : getNome();
        telefone=condutorUpdateDTO.getTelefone() != null ? condutorUpdateDTO.getTelefone() : getTelefone();
        email=condutorUpdateDTO.getEmail() != null ? condutorUpdateDTO.getEmail() : getEmail();
        formaPagamento=condutorUpdateDTO.getFormaPagamento() != null ? condutorUpdateDTO.getFormaPagamento() : getFormaPagamento();
        this.endereco = endereco != null ? endereco : this.endereco;
    }
}
