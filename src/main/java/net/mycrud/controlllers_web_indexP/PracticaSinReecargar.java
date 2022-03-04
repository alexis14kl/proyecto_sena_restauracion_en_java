package net.mycrud.controlllers_web_indexP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.model.User;

@Controller
public class PracticaSinReecargar {
	
	@Autowired
private ImplementsIServiceUser ImplementsIServiceUser;
		
	    @GetMapping("/data")
		public String mostrarData() {
			return "prueba";
		}
	    
	    @GetMapping(path = "/datosJs")
		public ResponseEntity<List<User>> consultarCorreosEnviados() {
			return ResponseEntity.status(HttpStatus.OK).body(ImplementsIServiceUser.searchusers());
		}

}
