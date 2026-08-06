package ifsc.ads.todolist.controller;

import ifsc.ads.todolist.model.Anotacao;
import ifsc.ads.todolist.service.AnotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anotacao")
public class AnotacaoController {
    @Autowired
    AnotacaoService anotacaoService;

    @PostMapping
    public ResponseEntity<Anotacao> criar(@RequestBody Anotacao anotacao){
        Anotacao salva = anotacaoService.criar(anotacao);
        return ResponseEntity.ok(salva);
    }
}
