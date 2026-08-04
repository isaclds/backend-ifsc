package ifsc.ads.todolist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @Column(name = "id_tarefa")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="horario_movimentacao")
    private LocalTime horarioMovimentacao;

    @Column(name="data")
    private LocalDateTime data;

    //Relacionamento com listas
    @ManyToOne
    @JoinColumn(name = "id_lista")
    @JsonBackReference
    private Lista lista;

    // Relacionamento com anotações
    @OneToMany(mappedBy = "tarefa")
    @JsonManagedReference
    private List<Anotacao> anotacoes;
}