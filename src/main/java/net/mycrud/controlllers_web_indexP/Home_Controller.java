package net.mycrud.controlllers_web_indexP;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home_Controller {

	// this controller is the index
	@GetMapping("/")
	public String show_Index() {
		return "index";
	}

	// this controller is the gallery
	@GetMapping("/gallery")
	public String showGallery() {
		return "gallery";
	}





	
	
	
	//practica de enviar objecto a js
//	@GetMapping("/user")
//	public @ResponseBody User getUser(Model model){
//	  User user = new User();
//	  user.setNombre_completo("yilson alexis malambo madrial programador");
//		return user;
//	}
//
//	//metodo funciona con api rest lista db
//	@GetMapping(path = "/user1")
//	public ResponseEntity<List<User>> consultarCorreosEnviados() {
//		return ResponseEntity.status(HttpStatus.OK).body(ImplementsIServiceUser.searchusersinaactivos());
//	}

}