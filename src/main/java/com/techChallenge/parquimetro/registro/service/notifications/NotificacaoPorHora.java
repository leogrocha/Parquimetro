package com.techChallenge.parquimetro.registro.service.notifications;

import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.dto.RegistroNotificacaoDTO;
import com.techChallenge.parquimetro.registro.projection.RegistroPendentesProjection;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class NotificacaoPorHora {

    private RegistroRepository registroRepository;

    public RegistroNotificacaoDTO enviarNotificacaoPorHora() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        var listaRegistrosPendentes = registroRepository.findAllByFimRegistroNull();
        System.out.println(listaRegistrosPendentes);

        RegistroNotificacaoDTO registroNotificacaoDTO = new RegistroNotificacaoDTO();
        executorService.scheduleAtFixedRate(() -> {
            for(RegistroPendentesProjection item: listaRegistrosPendentes) {
            String message = item.getNome() + " será atualizado o período de estacionamento em mais 1 hora. \n Valor atual R$" + item.getValor_total();
            registroNotificacaoDTO.setMessage(message);
            System.out.println(registroNotificacaoDTO);
            }
        }, 0, 1, TimeUnit.MINUTES); // Executa a cada hora

        return registroNotificacaoDTO;
    }



}
