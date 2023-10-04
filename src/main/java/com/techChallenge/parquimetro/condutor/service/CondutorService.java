package com.techChallenge.parquimetro.condutor.service;

import com.techChallenge.parquimetro.condutor.dto.CondutorFiltroDTO;
import com.techChallenge.parquimetro.condutor.specifications.CondutorFiltro;
import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.condutor.dto.CondutorDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorSaveDTO;
import com.techChallenge.parquimetro.condutor.dto.CondutorUpdateDTO;
import com.techChallenge.parquimetro.condutor.domain.Condutor;
import com.techChallenge.parquimetro.config.exceptions.DatabaseException;
import com.techChallenge.parquimetro.endereco.domain.Endereco;
import com.techChallenge.parquimetro.condutor.repository.CondutorRepository;
import com.techChallenge.parquimetro.endereco.dto.EnderecoSaveDTO;
import com.techChallenge.parquimetro.endereco.dto.EnderecoUpdateDTO;
import com.techChallenge.parquimetro.endereco.repository.EnderecoRepository;
import com.techChallenge.parquimetro.veiculo.domain.Veiculo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Service
@AllArgsConstructor
public class CondutorService {

    private final CondutorRepository repository;
    private final EnderecoRepository enderecoRepository;
    private final CondutorFiltro condutorFiltro;

    @Transactional(readOnly = true)
    public List<CondutorDTO> findAll(CondutorFiltroDTO condutorFiltroDTO) {
        return repository.findAll(condutorFiltro.aplicarFiltro(condutorFiltroDTO))
                .stream().map(CondutorDTO::of).toList();
    }

    @Transactional(readOnly = true)
    public CondutorDTO findById(Long condutorId) {
        return repository.findById(condutorId).stream()
                .map(CondutorDTO::of)
                .findFirst().orElseThrow(() -> new ControllerNotFoundException("Condutor não encontrado."));
    }
    @Transactional
    public CondutorDTO save(CondutorSaveDTO condutorSaveDTO) {
        validarSeCpfJaFoiCadastrado(condutorSaveDTO.getCpf());
        var endereco = enderecoRepository.save(Endereco.ofSave(condutorSaveDTO.getEndereco()));
        var condutor = repository.save(Condutor.ofSave(condutorSaveDTO, endereco));
        return CondutorDTO.of(condutor);

    }

    @Transactional
    public CondutorDTO update(CondutorUpdateDTO condutorUpdateDTO, Long condutorId) {

        try {

            var condutor = repository.getReferenceById(condutorId);
            var endereco = Endereco.ofUpdate(condutorUpdateDTO.getEndereco());
            endereco.setEnderecoId(condutor.getEndereco().getEnderecoId());
            CondutorUpdateDTO.mapperEntity(condutorUpdateDTO, condutor, endereco);
            endereco = enderecoRepository.save(endereco);
            condutor = repository.save(condutor);
            return CondutorDTO.of(condutor);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Condutor não encontrado, id: " + condutorId);
        }

    }

    @Transactional
    public CondutorDTO updateCondutorVeiculo(CondutorUpdateDTO condutorUpdateDTO, Veiculo veiculo, Long condutorId) {

        try {

            var condutor = repository.getReferenceById(condutorId);
            var endereco = Endereco.ofUpdate(condutorUpdateDTO.getEndereco());
            endereco.setEnderecoId(condutor.getEndereco().getEnderecoId());
            CondutorUpdateDTO.mapperEntity(condutorUpdateDTO, condutor, endereco);
            endereco = enderecoRepository.save(endereco);
            condutor.getVeiculos().add(veiculo);
            condutor = repository.save(condutor);
            return CondutorDTO.of(condutor);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Condutor não encontrado, id: " + condutorId);
        }

    }

    public void validarSeCpfJaFoiCadastrado(String cpf) {
        boolean cpfJaFoiCadastrado = repository.existsByCpf(cpf);
        if(cpfJaFoiCadastrado) {
            throw new DatabaseException("CPF já cadastrado na base de dados.");
        }
    }





}
