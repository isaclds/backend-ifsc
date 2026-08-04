package ifsc.ads.todolist.service;

import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.model.Tarefa;
import ifsc.ads.todolist.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> buscarTodas(){
        return tarefaRepository.findAll();
    }

    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscaPorId(String id) {
        return tarefaRepository.getReferenceById(id);
    }
}
