package net.mycrud.controllersDelSistema;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.model.User;




@Controller
public class ControllerSystemIndex {

	@Autowired
	private ImplementsIServiceUser ImplementsIServiceUser;
	
	
	@GetMapping("/registrar_productos")
	public String registerProducts(Model model, Authentication auth, HttpSession theSession) {
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
		return"system/Registrar_productos/RP";
	}
	
	

	@PostMapping("/registerP")
	public String saveProduct(RedirectAttributes theRedirect, @Validated String producto,  Authentication auth, HttpSession theSession) {
		System.out.println("producto == >");
		return"redirect:/registrar_productos";
	}
	
	
	

	



	
	
	
	
	
	

}
 