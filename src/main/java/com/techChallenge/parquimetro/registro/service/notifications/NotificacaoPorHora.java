package com.techChallenge.parquimetro.registro.service.notifications;

import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.registro.dto.RegistroNotificacaoDTO;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class NotificacaoPorHora {

    private RegistroRepository registroRepository;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private final Map<Long, Boolean> registrosAtivos = new ConcurrentHashMap<>();

    public void enviarNotificacaoPorHora(Long registroId) {

        registrosAtivos.put(registroId, true);

        executorService.scheduleAtFixedRate(() -> {
        boolean registroAtivo = registrosAtivos.getOrDefault(registroId, false);
            if(registroAtivo) {
                var registro = registroRepository.findById(registroId)
                        .orElseThrow(() -> new ControllerNotFoundException("Registro não encontrado"));
                if(registro.getFimRegistro()==null) {
                    RegistroNotificacaoDTO registroNotificacaoDTO = new RegistroNotificacaoDTO();
                    String message = registro.getCondutor().getNome() + " será atualizado o período de estacionamento em mais 1 hora. \n Valor atual R$" + registro.getValorTotal();
                    registroNotificacaoDTO.setMessage(message);
                    System.out.println(registroNotificacaoDTO);
                } else registrosAtivos.put(registroId, false);
            }

            registrosAtivos.entrySet().stream().map(register -> "Registros ativos: " + register).forEach(System.out::println);

        }, 30, 3600, TimeUnit.SECONDS);
    }

}
