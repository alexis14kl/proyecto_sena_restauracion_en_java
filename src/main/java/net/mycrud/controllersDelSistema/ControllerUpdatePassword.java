package net.mycrud.controllersDelSistema;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	public String updatePassword(@RequestParam("id") int id, 
			@RequestParam("newpass") String newpass ) {
		System.out.println("este es el id obtenido " + id  + newpass );
		try {
			implementsServiceUpdatePassword.buscarPorid(id);
		} catch (Exception e) {
	        System.out.println("mensaje exception " + e.getLocalizedMessage().toString());
		}
		return null;
	}
	
	@GetMapping("/endPassword")
	@ResponseBody
	public String updatepassend(HttpServletRequest request,int id,  String newpass) {
		try {
			implementsServiceUpdatePassword.updatePassword(id,  "{noop}"+newpass);
		} catch (Exception e) {
			//deleted session
			SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			logoutHandler.logout(request, null, null);
			return e.getLocalizedMessage();
		}
		return null;
	}

}
