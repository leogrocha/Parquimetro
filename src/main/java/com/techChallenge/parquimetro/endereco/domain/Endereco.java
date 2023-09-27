package com.techChallenge.parquimetro.endereco.domain;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.endereco.dto.EnderecoSaveDTO;
import com.techChallenge.parquimetro.endereco.dto.EnderecoUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_endereco")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"enderecoId"})
@ToString
@Getter
@Setter
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

    public Endereco(EnderecoUpdateDTO enderecoUpdateDTO) {
        enderecoId = enderecoUpdateDTO.getEnderecoId();
        logradouro = enderecoUpdateDTO.getLogradouro() != null ? enderecoUpdateDTO.getLogradouro() : getLogradouro();
        bairro = enderecoUpdateDTO.getBairro() != null ? enderecoUpdateDTO.getBairro() : getBairro();
        numero = enderecoUpdateDTO.getNumero() != null ? enderecoUpdateDTO.getNumero() : getNumero();
        complemento = enderecoUpdateDTO.getComplemento() != null ? enderecoUpdateDTO.getComplemento() : getComplemento();
        cep = enderecoUpdateDTO.getCep() != null ? enderecoUpdateDTO.getCep() : getCep();
        municipio= enderecoUpdateDTO.getMunicipio() != null ? enderecoUpdateDTO.getMunicipio() : getMunicipio();
    }




}
