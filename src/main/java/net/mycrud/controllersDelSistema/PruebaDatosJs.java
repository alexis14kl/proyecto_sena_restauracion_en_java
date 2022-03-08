package net.mycrud.controllersDelSistema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaDatosJs {
	
	@GetMapping("/datas")
	public String mostarData() {
		return"system/data";
	}

}
