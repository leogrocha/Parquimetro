package com.techChallenge.parquimetro.registro.service.notifications;

import com.techChallenge.parquimetro.config.exceptions.ControllerNotFoundException;
import com.techChallenge.parquimetro.registro.dto.RegistroNotificacaoDTO;
import com.techChallenge.parquimetro.registro.repository.RegistroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class NotificacaoPeriodoFixo {

    private RegistroRepository registroRepository;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private final Map<Long, Boolean> registrosAtivos = new ConcurrentHashMap<>();

    public void enviarNotificacaoPeriodoFixo(Long registroId) {

        registrosAtivos.put(registroId, true);

        executorService.scheduleAtFixedRate(() -> {
        boolean registroAtivo = registrosAtivos.getOrDefault(registroId, false);
            if(registroAtivo) {
                var registro = registroRepository.findById(registroId)
                        .orElseThrow(() -> new ControllerNotFoundException("Registro não encontrado"));

                LocalDateTime fimRegistro = registro.getFimRegistro();
                LocalDateTime agora = LocalDateTime.now();
                LocalDateTime trintaMinutosAntesFimRegistro = fimRegistro.minusMinutes(30);
                boolean enviarNotificacao = agora.equals(trintaMinutosAntesFimRegistro);

                if(enviarNotificacao) {
                    RegistroNotificacaoDTO registroNotificacaoDTO = new RegistroNotificacaoDTO();
                    String message = registro.getCondutor().getNome() + " faltam 30 minutos para o fim do período estacionado. \n Valor atual R$" + registro.getValorTotal();
                    registroNotificacaoDTO.setMessage(message);
                    System.out.println(registroNotificacaoDTO);
                } else registrosAtivos.put(registroId, false);
            }

            registrosAtivos.entrySet().stream().map(register -> "Registros ativos: " + register).forEach(System.out::println);

        }, 5, 60, TimeUnit.SECONDS); // Executa a cada hora
    }

}
