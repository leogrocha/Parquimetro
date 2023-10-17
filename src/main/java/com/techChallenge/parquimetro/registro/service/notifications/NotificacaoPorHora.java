package com.techChallenge.parquimetro.registro.service.notifications;

import com.techChallenge.parquimetro.registro.domain.Registro;
import com.techChallenge.parquimetro.registro.dto.RegistroDTO;
import com.techChallenge.parquimetro.registro.dto.RegistroNotificacaoDTO;
import com.techChallenge.parquimetro.registro.projection.RegistroPendentesProjection;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class NotificacaoPorHora {

    private RegistroRepository registroRepository;

//    public void enviarNotificacaoPorHora() {
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//
//        executorService.scheduleAtFixedRate(() -> {
//            for(RegistroPendentesProjection item: registroRepository.findAllByFimRegistroNull()) {
//                RegistroNotificacaoDTO registroNotificacaoDTO = new RegistroNotificacaoDTO();
//                String message = item.getNome() + " será atualizado o período de estacionamento em mais 1 hora. \n Valor atual R$" + item.getValor_total();
//                registroNotificacaoDTO.setMessage(message);
//                System.out.println(registroNotificacaoDTO);
//            }
//        }, 0, 1, TimeUnit.MINUTES); // Executa a cada hora
//
//    }

    @Scheduled(fixedRate = 60000)
    public void enviarNotificacaoPorHora() {
        LocalDateTime now = LocalDateTime.now();
        List<RegistroPendentesProjection> listaRegistrosPendentes = registroRepository.findAllByFimRegistroNull();

        for(RegistroPendentesProjection registro : listaRegistrosPendentes) {
            LocalDateTime inicioEstacionamento = registro.getInicio_registro();
            Duration duracaoEstacionamento = Duration.between(inicioEstacionamento, now);

            if(duracaoEstacionamento.toMinutes() >= 1) {
                RegistroNotificacaoDTO registroNotificacaoDTO = new RegistroNotificacaoDTO();
                String message = registro.getNome() + " será atualizado o período de estacionamento em mais 1 hora. \n Valor atual R$" + registro.getValor_total();
                registroNotificacaoDTO.setMessage(message);
                System.out.println(registroNotificacaoDTO);
            }
        }

    }



}
