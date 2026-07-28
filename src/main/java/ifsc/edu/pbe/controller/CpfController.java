package ifsc.edu.pbe.controller;

import ifsc.edu.pbe.model.Cpf;
import ifsc.edu.pbe.model.ErrorResponse;
import ifsc.edu.pbe.service.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CpfController {
    @Autowired
    private CpfService cpfService;

    @GetMapping("/api/verificador/{cpf}")
    public ResponseEntity<Object> verifcaCpfUrl(@PathVariable("cpf") String cpf) {
        boolean valido = cpfService.isValido(cpf);

        if (!valido) {
            return ResponseEntity.badRequest().body(new ErrorResponse(400, "CPF Inválido"));
        }

        return ResponseEntity.ok(new Cpf(cpf));
    }

    @GetMapping("/api/verificador/")
    public ResponseEntity<Object> verificaCpf(@RequestParam String cpf) {
        boolean valido = cpfService.isValido(cpf);

        if (!valido) {
            return ResponseEntity.badRequest().body(new ErrorResponse(400, "CPF Inválido"));
        }

        return ResponseEntity.ok(new Cpf(cpf));
    }

    @PostMapping("/api/verificador/")
    public ResponseEntity<Object> verificaCpfPost(@RequestBody Cpf body) {
        String valorCpf = body.cpf();
        boolean valido = cpfService.isValido(valorCpf);

        if (!valido) {
            return ResponseEntity.badRequest().body(new ErrorResponse(400, "CPF Inválido"));
        }

        return ResponseEntity.ok(new Cpf(valorCpf));
    }
}
