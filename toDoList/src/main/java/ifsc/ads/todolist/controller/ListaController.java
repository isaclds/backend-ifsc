package ifsc.ads.todolist.controller;

import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaController {
    @Autowired
    ListaService listaService;

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
}
