package ifsc.ads.todolist.repository;

import ifsc.ads.todolist.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, String> {
}