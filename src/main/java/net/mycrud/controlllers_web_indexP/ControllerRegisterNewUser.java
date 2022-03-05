package net.mycrud.controlllers_web_indexP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.implementaciones.ImplementsServiceDataGeneral;
import net.mycrud.implementaciones.ImplementsServiceProfile;
import net.mycrud.implementaciones.ImplementsServiceUp;
import net.mycrud.model.DataGeneral;
import net.mycrud.model.ProfileUser;
import net.mycrud.model.User;
import net.mycrud.model.UserProfile;



@Controller
public class ControllerRegisterNewUser {
	
	@Autowired
	private ImplementsIServiceUser implementsIServiceUser;
	
	@Autowired
	private ImplementsServiceUp implementsServiceUp;
	
	@Autowired
	private ImplementsServiceProfile implementsServiceProfile;
	
	@Autowired
	private ImplementsServiceDataGeneral implementsServiceDataGeneral;


	@GetMapping("/register")
	public String RegisterUser(Model theModel) {
		String register = "register";
		List<ProfileUser> ResultadoObtenidoProfile = implementsServiceProfile.consultarProfile();
		theModel.addAttribute("register", register);
		theModel.addAttribute("consultaProfile", ResultadoObtenidoProfile);
		return "register";
	}
	
	@GetMapping("/validarEmailNewUser")
	@ResponseBody
	public String validarEmail(@RequestParam(name="name") String name,
			                   @RequestParam(name="email") String email,
			                   @RequestParam(name="clave1") String clave1,
			                   @RequestParam(name="clave2") String clave2,
			                   @RequestParam(name="perfil") String perfil) {
	  System.out.println(email + name + clave1 + clave2 + perfil);
	  
	return devolverEmail(email, name, clave1, clave2, perfil);
	  
	}
	

	@GetMapping("/devolverEmail")
	@ResponseBody
	public String devolverEmail(String email, String name, String clave1, String clave2, String perfil) {
		List<String> info = implementsIServiceUser.buscarCorreo(email);
		if(!info.isEmpty()) {
			return "el correo ya existe";
		}else {
			User u = new User();
			u.setNombre_completo(name);
			u.setUsername(email);
			u.setPassword("{noop}"+clave1);
			u.setEstatus(1);
			u.setConect(0);
			implementsIServiceUser.guardarUser(u);
			//register perfil
			User consultarUserRegistering = implementsIServiceUser.buscarUserporCorreo(email);
			if(consultarUserRegistering != null) {
				System.out.println("este es el usuario registrado " + consultarUserRegistering.getNombre_completo().toString());
				UserProfile up = new UserProfile();
				up.setIdperfil(perfil);
				up.setIdusuario(consultarUserRegistering.getId());
				implementsServiceUp.guardarUp(up);
				//continuacion si hay que continuar con angunos arreglos
				//guardar registro de la tabla datos generales
				//saved id auto regeratedValue by system
				int cod = implementsIServiceUser.generatedValue();
				System.out.println("este es el id generad por el sistema " + cod);
				DataGeneral dataG = new DataGeneral();
				dataG.setIdusuario(consultarUserRegistering.getId());
				dataG.setCod_cliente(cod);
				dataG.setNumero_cc("no ");
				dataG.setTipo_documento("no");
				dataG.setDireccion("no");
				dataG.setTelefono("no");
				//hay que actualizar poner campus del asessor pendiente
				implementsServiceDataGeneral.guardardataG(dataG);
			}
			
		}
		return "correo registrado";
	}
}
