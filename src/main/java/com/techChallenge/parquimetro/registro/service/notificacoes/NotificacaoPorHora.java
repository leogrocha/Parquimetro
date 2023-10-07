package com.techChallenge.parquimetro.registro.service.notificacoes;

import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroNotificacaoDTO;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class NotificacaoPorHora {

    private RegistroRepository registroRepository;

    public RegistroNotificacaoDTO enviarNotificacao(Registro registro) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        RegistroNotificacaoDTO registroNotificacaoDTO = new RegistroNotificacaoDTO();
        executorService.scheduleAtFixedRate(() -> {
            String message = registro.getCondutor().getNome() + " será atualizado o período de estacionamento em mais 1 hora.";
            registroNotificacaoDTO.setMessage(message);
            System.out.println(registroNotificacaoDTO);
        }, 0, 1, TimeUnit.MINUTES); // Executa a cada hora

        return registroNotificacaoDTO;
    }



}
