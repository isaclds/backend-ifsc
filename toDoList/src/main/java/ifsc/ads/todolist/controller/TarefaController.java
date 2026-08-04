package ifsc.ads.todolist.controller;

import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.model.Tarefa;
import ifsc.ads.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa){
        Tarefa salva = tarefaService.criar(tarefa);
        return ResponseEntity.ok(salva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable String id){
        Tarefa encontrada = tarefaService.buscaPorId(id);
        return  ResponseEntity.ok(encontrada);
    }


}
