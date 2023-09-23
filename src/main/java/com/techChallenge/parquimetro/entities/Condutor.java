package com.techChallenge.parquimetro.entities;

import com.techChallenge.parquimetro.dto.CondutorDTO;
import com.techChallenge.parquimetro.dto.CondutorSaveDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "tb_condutor")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
