package com.techChallenge.parquimetro.condutor.dto;

import com.techChallenge.parquimetro.condutor.domain.Condutor;
import lombok.*;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"condutorId"})
@ToString
@Getter
@Setter
public class CondutorRegistroDTO {

    private Long condutorId;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public static CondutorRegistroDTO of(Condutor condutor) {
        CondutorRegistroDTO condutorRegistroDTO = new CondutorRegistroDTO();
        BeanUtils.copyProperties(condutor, condutorRegistroDTO);
        return condutorRegistroDTO;
    }
}
