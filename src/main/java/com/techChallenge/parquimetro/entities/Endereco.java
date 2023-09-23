package com.techChallenge.parquimetro.entities;

import com.techChallenge.parquimetro.dto.EnderecoDTO;
import com.techChallenge.parquimetro.dto.EnderecoSaveDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoId;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String municipio;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Condutor condutor;

    public Endereco(EnderecoSaveDTO enderecoDTO) {
        logradouro = enderecoDTO.getLogradouro();
        bairro = enderecoDTO.getBairro();
        numero = enderecoDTO.getNumero();
        complemento = enderecoDTO.getComplemento();
        cep = enderecoDTO.getCep();
        municipio= enderecoDTO.getMunicipio();
    }




}
