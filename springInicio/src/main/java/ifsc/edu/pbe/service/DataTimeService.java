package ifsc.edu.pbe.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class DataTimeService {

    public String getData() {
        LocalDate hoje = LocalDate.now();
        var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formato.format(hoje);
    }

    public String getHorario() {
        LocalTime agora = LocalTime.now();
        var formato = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        return formato.format(agora);
    }
}