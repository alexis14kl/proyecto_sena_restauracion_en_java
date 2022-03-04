package net.mycrud.controlllers_web_indexP;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mycrud.implementaciones.ImplementsIServiceUser;

@Controller
public class ControllerCerrarSession {
	@Autowired
	private ImplementsIServiceUser implementsIServiceUser;
	//exist
		@GetMapping("/logout")
		@ResponseBody
		public String logout(HttpServletRequest request, @RequestParam("correo") String correo) {
			SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			implementsIServiceUser.updateconnect(0, correo);
			logoutHandler.logout(request, null, null);
			return "hola";
		}
}
