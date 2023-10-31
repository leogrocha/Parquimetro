package com.techChallenge.parquimetro.endereco.domain;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.endereco.dto.EnderecoSaveDTO;
import com.techChallenge.parquimetro.endereco.dto.EnderecoUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

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


    public static Endereco ofSave(EnderecoSaveDTO enderecoSaveDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoSaveDTO, endereco);
        return endereco;
    }

    public static Endereco ofUpdate(EnderecoUpdateDTO enderecoUpdateDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoUpdateDTO, endereco);
        return endereco;
    }






}
