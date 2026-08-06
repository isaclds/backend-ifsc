package ifsc.ads.todolist.service;

import ifsc.ads.todolist.dto.tarefa.MoverTarefaRequest;
import ifsc.ads.todolist.dto.tarefa.TarefaRequest;
import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.model.Tarefa;
import ifsc.ads.todolist.repository.ListaRepository;
import ifsc.ads.todolist.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private ListaRepository listaRepository;

    public List<Tarefa> buscarTodas(){
        return tarefaRepository.findAll();
    }

    public Tarefa criar(TarefaRequest request) {
        Lista lista = listaRepository.findById(request.idLista())
                .orElseThrow(() -> new EntityNotFoundException("Lista não encontrada: " + request.idLista()));

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(request.nome());
        tarefa.setDescricao(request.descricao());
        tarefa.setHorarioMovimentacao(request.horarioMovimentacao());
        tarefa.setData(request.data());
        tarefa.setLista(lista);

        return tarefaRepository.save(tarefa);
    }
    public Tarefa buscaPorId(String id) {
        return tarefaRepository.getReferenceById(id);
    }

    public Tarefa moverTarefa(String id, MoverTarefaRequest request) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada: " + id));

        Lista novaLista = listaRepository.findById(request.idLista())
                .orElseThrow(() -> new EntityNotFoundException("Lista não encontrada: " + request.idLista()));

        tarefa.setLista(novaLista);

        return tarefaRepository.save(tarefa);
    }

    public void deletar(String id) {
        if (!tarefaRepository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada: " + id);
        }
        tarefaRepository.deleteById(id);
    }

    public List<Tarefa> buscarTarefasPorLista(String idLista) {
        if (!listaRepository.existsById(idLista)) {
            throw new EntityNotFoundException("Lista não encontrada: " + idLista);
        }
        return tarefaRepository.findByListaIdOrderByDataAsc(idLista);
    }
}
