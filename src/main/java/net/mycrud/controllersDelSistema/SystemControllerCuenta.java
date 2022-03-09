package net.mycrud.controllersDelSistema;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.mycrud.dtos.UserDTO;
import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.model.DataGeneral;
import net.mycrud.model.User;

@Controller
public class SystemControllerCuenta {
	
	@Autowired
	private ImplementsIServiceUser ImplementsIServiceUser;

	@GetMapping("/cuenta")
	@ResponseStatus(HttpStatus.OK)
	public String shoeConnect(Model model, Authentication auth, HttpSession theSession) {
		//datos de recuperacion session
		String correo = auth.getName();
		for(GrantedAuthority rol: auth.getAuthorities()) {
			model.addAttribute("rol", rol.getAuthority());
			//System.out.println("este es el rol " + rol.getAuthority());
		}
		if(theSession.getAttribute("usuario") == null) {
			User usuario = ImplementsIServiceUser.buscarUserporCorreo(correo);
			usuario.setPassword(null);
			theSession.setAttribute("datosUser", usuario);
		}//end the session
		List<UserDTO> user = ImplementsIServiceUser.datosGenerales(correo);
		model.addAttribute("data", user);
		return"system/cuenta";
	}
	
	
@GetMapping("/saveDataGeneral")
@ResponseBody

public String saveDataGeneral(@RequestParam("id_number") String id_number,
		                      @RequestParam("data_type") String data_type,
		                      @RequestParam("data_phone") String data_phone, 
		                      @RequestParam("data_address") String data_address,
		                      @RequestParam("iduser") String iduser) throws Exception {
	try {
		ImplementsIServiceUser.updateDataUserGeneral(id_number, data_type, data_phone, data_address, iduser);
		System.out.println("datos son estos " + id_number + data_type + data_phone + data_address);
	}catch(Exception e) {
		System.out.println("error " + e.getLocalizedMessage().toString());
		return e.getLocalizedMessage().toString();
	}
	return null;
}
	
	
	
	
	//eliminar cuenta
	@GetMapping("/deleted")
	@ResponseBody
	public String deleted(HttpServletRequest request,@RequestParam("id") int id) {
		System.out.println("este es el id " + id);
		List<User> resultado = ImplementsIServiceUser.buscarPorid(id);
		if(resultado != null) {
			SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			logoutHandler.logout(request, null, null);
			ImplementsIServiceUser.delete(id);
		}else {
			return "error";
		}
		return"eliminado";
	}
	
}
