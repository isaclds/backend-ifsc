package ifsc.edu.pbe.controller;

import ifsc.edu.pbe.model.Agora;
import ifsc.edu.pbe.model.Data;
import ifsc.edu.pbe.model.Horario;
import ifsc.edu.pbe.model.Pong;
import ifsc.edu.pbe.service.DataTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @Autowired
    private DataTimeService dataTimeService;

    @GetMapping("/ping")
    public Pong ping() {
        return new Pong(200, "pong");
    }

    @GetMapping("/data")
    public Data data() {
        return new Data(200, dataTimeService.getData());
    }

    @GetMapping("/horario")
    public Horario horario() {
        return new Horario(200, dataTimeService.getHorario());
    }

    @GetMapping("/agora")
    public Agora agora() {
        return new Agora(200, dataTimeService.getData(), dataTimeService.getHorario());
    }
}