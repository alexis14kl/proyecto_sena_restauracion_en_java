package net.mycrud.controlllers_web_indexP;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.model.User;

@Controller
public class ControllerLogin {
	
	@Autowired
	private ImplementsIServiceUser implementsIServiceUser;
	private String datos;

	
	@GetMapping("/login")
	public String showLogin(Model theModel) {
		String accessbloqueo = "login";
		theModel.addAttribute("accessbloqueo", accessbloqueo);
		return "/loginP";
	}
	
	
	@RequestMapping("/datos")
	@ResponseBody
	public String datos(@RequestParam("nombre") String nombre, @RequestParam("pass") String pass) {
		if(!nombre.isEmpty() && !pass.isEmpty()) {//validar parametros del formulario
			User user = implementsIServiceUser.buscarUserporCorreo(nombre);
		    if(user != null) { //validar si hay correo
				List<User> usuario = implementsIServiceUser.buscarCorreoxcorreo(user.getUsername().toString(),"{noop}"+pass);
				if(usuario.isEmpty()) {//validar usuario obtenido y validar contraseña
					return"mal";
				}else {
					this.datos = usuario.get(0).getUsername();
	                 return"yes";
				}
		    }else {
		    	return"no"; //enviar mensaje de no hay correo registrados
		    }
		}
		
		return"hola";
	}
	
	
	
	//system principal login
		@GetMapping("/Bienvenido")
		public String systemIndem(Model model, Authentication auth, HttpSession theSession) {

			String correo = auth.getName();
			implementsIServiceUser.updateconnect(1, correo);//updated connect
			for(GrantedAuthority rol: auth.getAuthorities()) {
				model.addAttribute("rol", rol.getAuthority());
				//System.out.println("este es el rol " + rol.getAuthority());
			}
			if(theSession.getAttribute("usuario") == null) {
				User usuario = implementsIServiceUser.buscarUserporCorreo(this.datos);
				usuario.setPassword(null);
				theSession.setAttribute("datosUser", usuario);
			}
			return"system/index";
		}
		
}
