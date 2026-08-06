package ifsc.ads.todolist.controller;

import ifsc.ads.todolist.dto.tarefa.MoverTarefaRequest;
import ifsc.ads.todolist.dto.tarefa.TarefaRequest;
import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.model.Tarefa;
import ifsc.ads.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody TarefaRequest req){
        Tarefa salva = tarefaService.criar(req);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> buscarTodas(){
        List<Tarefa> tarefas = tarefaService.buscarTodas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable String id){
        Tarefa encontrada = tarefaService.buscaPorId(id);
        return  ResponseEntity.ok(encontrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> moverTarefa(
            @PathVariable String id,
            @RequestBody MoverTarefaRequest request
    ){
        Tarefa encontrada = tarefaService.moverTarefa(id, request);
        return  ResponseEntity.ok(encontrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
