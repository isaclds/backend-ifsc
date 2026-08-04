package ifsc.ads.todolist.repository;

import ifsc.ads.todolist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, String> {
}