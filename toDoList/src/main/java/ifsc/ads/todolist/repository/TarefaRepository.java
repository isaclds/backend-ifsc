package ifsc.ads.todolist.repository;

import ifsc.ads.todolist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, String> {
    List<Tarefa> findByListaIdOrderByDataAsc(String idLista);
}