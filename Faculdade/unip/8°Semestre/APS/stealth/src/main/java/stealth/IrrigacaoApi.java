package stealth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/irrigacao")
public class IrrigacaoApi {

	@GetMapping
	public void helf_check() {
		// verifica conexao com sensor
	}

	@GetMapping("/controla")
	public void controla_irrigacao() {
		// on/off sensor
	}

	@GetMapping("/verifica")
	public void verifica_irrigacao() {
		// verifica estado do sensor
	}

}
