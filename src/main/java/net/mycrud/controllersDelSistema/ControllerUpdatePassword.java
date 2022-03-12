package net.mycrud.controllersDelSistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mycrud.implementaciones.ImplementsServiceUpdatePassword;

@Controller
public class ControllerUpdatePassword {
	
	@Autowired
	private ImplementsServiceUpdatePassword implementsServiceUpdatePassword;
	
	@GetMapping("/updatePassword")
	@ResponseBody
	public String updatePassword(@RequestParam("id") int id, @RequestParam("passanterior") String passanterior,
			@RequestParam("newpass") String newpass ) {
		System.out.println("este es el id obtenido " + id + passanterior + newpass );
		try {
			implementsServiceUpdatePassword.buscarPorid(id);
		} catch (Exception e) {
	        System.out.println("mensaje exception " + e.getLocalizedMessage().toString());
		}
		return null;
	}
	
	@GetMapping("/endPassword")
	@ResponseBody
	public String updatepassend(int id, String passanterior, String newpass) {
		try {
			System.out.println("data del controllerAnterior " + id + passanterior + newpass );
			implementsServiceUpdatePassword.updatePassword(id, passanterior, "{noop}"+newpass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("mensaje 2 " + e.getLocalizedMessage().toString());
			return e.getLocalizedMessage();
		}
		return null;
	}

}
