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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.implementaciones.ImplementsServiceMessage;
import net.mycrud.model.Message;
import net.mycrud.model.User;




@Controller
public class ControllerSystemIndex {

	@Autowired
	private ImplementsIServiceUser ImplementsIServiceUser;
	
	@Autowired
	private ImplementsServiceMessage implementsServiceMessage;
	
	
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
	
	@GetMapping("/conectados")
	@ResponseStatus(HttpStatus.OK)
	public String shoeConnect(Model model, Authentication auth, HttpSession theSession) {
		
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
		
		try {
			 List<User> lista = ImplementsIServiceUser.searchusers();
			 model.addAttribute("lista", lista);
			 if(lista.isEmpty()) {
				 model.addAttribute("error1", lista);
			 }
			 List<User>listainactiva = ImplementsIServiceUser.searchusersinaactivos();
			 model.addAttribute("listai", listainactiva);
			 if(listainactiva.isEmpty()) {
				 model.addAttribute("error2", "No hay usuarios Desconectados");
			 }
			return"system/connect";
			
		} catch (Exception e) {
			System.out.println("error " + e.getLocalizedMessage());
		}
		return"system/connect";

		
	}
	

	//modal messAGE uardar
	@GetMapping("/message")
	@ResponseBody
	public String message(@RequestParam("message") String message,@RequestParam("id") String id, Authentication auth,HttpSession theSession) {
		String correo = auth.getName();
       if(message.isEmpty()) {
    	   System.out.println("el mensaje es obligatorio");
       }else {
    	   if(id.isEmpty()) {
    			
    			System.out.println("el id es obligatorio");
    	   }else {
    		   if(!message.isEmpty() || !id.isEmpty()) {
    			    User usuario = ImplementsIServiceUser.buscarUserporCorreo(correo);
	       			Message mensage = new Message();
	       			mensage.setIdusuario(usuario.getId());
	       			mensage.setMessage(message);
	       			mensage.setDestinario(id);
	       			if(!implementsServiceMessage.guardarMensage(mensage).isEmpty()) {   				
	       				hola(id, usuario.getId());
	       				System.out.println("mensaje guardado");
	       			};
    		   }
    	   }
       }
		return null;
	}



	
	
	@GetMapping(path = "/hola")
	public ResponseEntity<List<Message>> hola(String id, int i) {
		//i id user
		//id destinario
		
		System.out.println("mensaages ok " + id + i);
		List<Message>l = implementsServiceMessage.seachMessages(id);
		System.out.println("consullta mensajes" + l.toString());
		return ResponseEntity.status(HttpStatus.OK).body(l);
	}
	
	
	

}
 