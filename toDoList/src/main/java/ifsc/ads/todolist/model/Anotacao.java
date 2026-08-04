package ifsc.ads.todolist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "anotacao")
public class Anotacao {
    @Id
    @Column(name = "id_anotacao")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "horario_criacao")
    private LocalTime horarioCriacao;

    @ManyToOne
    @JoinColumn(name = "id_tarefa")
    @JsonBackReference
    private Tarefa tarefa;
}