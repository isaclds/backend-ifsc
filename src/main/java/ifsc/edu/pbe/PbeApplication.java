package ifsc.edu.pbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@SpringBootApplication
@RestController
public class PbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbeApplication.class, args);
	}

	record Pong(int status, String title){	}
	@GetMapping("/ping")
	public Pong ping() {
		return new Pong(200, "pong");
	}

	record Data(String data){}
	@GetMapping("/data")
	public Data data(){
		return new Data(getData());
	}

	record Horario(String horario){}
	@GetMapping("/horario")
	public Horario horario(){
		return new Horario(getHorario());
	}

	record Agora(String data, String horario){}
	@GetMapping("/agora")
	public Agora agora(){
		return new Agora(getData() ,getHorario());
	}

	private String getData() {
		LocalDate hoje = LocalDate.now();
		var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formato.format(hoje);
	}

	private String getHorario() {
		LocalTime agora = LocalTime.now();
		var formato = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		return formato.format(agora);
	}
}