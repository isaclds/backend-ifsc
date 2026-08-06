package ifsc.ads.todolist.controller;

import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.model.Tarefa;
import ifsc.ads.todolist.service.ListaService;
import ifsc.ads.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaController {
    @Autowired
    ListaService listaService;
    @Autowired
    TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Lista> criar(@RequestBody Lista lista) {
        Lista salva = listaService.criar(lista);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Lista>> buscarTodas(){
        List<Lista> listas = listaService.buscarTodas();
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/{id}/tarefas")
    public ResponseEntity<List<Tarefa>> buscarTarefasDaLista(@PathVariable String id) {
        List<Tarefa> tarefas = tarefaService.buscarTarefasPorLista(id);
        return ResponseEntity.ok(tarefas);
    }
}
