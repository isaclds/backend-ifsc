package ifsc.ads.todolist.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "lista")
public class Lista {
    @Id
    @Column(name = "id_lista")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "lista")
    @JsonManagedReference
    private List<Tarefa> tarefas;
}