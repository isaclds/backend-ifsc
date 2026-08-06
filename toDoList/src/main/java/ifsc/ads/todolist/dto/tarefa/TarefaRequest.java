package ifsc.ads.todolist.dto.tarefa;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record TarefaRequest(
        String nome,
        String descricao,
        LocalTime horarioMovimentacao,
        LocalDateTime data,
        String idLista
) {}