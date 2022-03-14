package net.mycrud.controllersDelSistema;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.model.User;

@Controller
public class SystemControllerProducto {
	@Autowired
	private ImplementsIServiceUser ImplementsIServiceUser;
	@GetMapping("/productos")
	public String verProductos(Model model,Authentication auth, HttpSession theSession) {
		String correo = auth.getName();
		for(GrantedAuthority rol: auth.getAuthorities()) {
			model.addAttribute("rol", rol.getAuthority());
			//System.out.println("este es el rol " + rol.getAuthority());
		}
		if(theSession.getAttribute("usuario") == null) {
			User usuario = ImplementsIServiceUser.buscarUserporCorreo(correo);
			usuario.setPassword(null);
			theSession.setAttribute("datosUser", usuario);
		}
		return"system/products";
	}

}
