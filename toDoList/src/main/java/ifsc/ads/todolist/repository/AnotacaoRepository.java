package ifsc.ads.todolist.repository;

import ifsc.ads.todolist.model.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotacaoRepository extends JpaRepository<Anotacao, String>{
}