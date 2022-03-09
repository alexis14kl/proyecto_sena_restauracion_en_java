package net.mycrud.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.model.IModel;

import net.mycrud.dtos.UserDTO;
import net.mycrud.model.DataGeneral;
import net.mycrud.model.User;
import net.mycrud.repositorios.RepoUser;
import net.mycrud.services.IServiceUser;

@Service
public class ImplementsIServiceUser implements IServiceUser {
	
	@Autowired
	private RepoUser repoUser;
	

	@Override
	public List<String> buscarCorreo(String email) {
		// TODO Auto-generated method stub
		return repoUser.buscarCorreo(email);
	}

	@Override
	public int guardarUser(User datosusuario) {
         int rest = 0;
         User u = repoUser.save(datosusuario);
         if(u.equals(null)) {
        	 rest = 1;
         }
		return rest;
	}

	@Override
	public User buscarUserporCorreo(String correo) {
		return repoUser.findByUsername(correo);
	}

	@Override
	public void updateconnect(int conect, String correo) {
		
		repoUser.updateconnect(conect, correo);
		
	}

	@Override
	public List<User> searchusers() {
		return repoUser.searchusers();
	}

	@Override
	public List<User> searchusersinaactivos() {
		// TODO Auto-generated method stub
		return repoUser.searchusersinaactivos();
	}

	@Override
	public List<User> buscarCorreoxcorreo(String nombre, String pass) {
		// TODO Auto-generated method stub
		return repoUser.buscarCorreoxcorreo(nombre, pass);
	}

	@Override
	public int generatedValue() {
		// TODO Auto-generated method stub
		return repoUser.generatedValue();
	}

	@Override
	public List<UserDTO> datosGenerales(String correo) {
		List<UserDTO> user = repoUser.datosGenerales(correo);
		if(!user.isEmpty()) {
	         	user.get(0).getcod_cliente();
			    user.get(0).getdireccion();
			    user.get(0).getNombre_completo();
			    user.get(0).getusername();
		        user.get(0).getTelefono();
			    user.get(0).getid();
			    user.get(0).getNumero_cc();
			    user.get(0).gettipo_documento();
			    return user;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repoUser.deleteById(id);
		
	}

	@Override
	public List<User> buscarPorid(int id) {
		return  repoUser.buscarPorid(id);
	}

	@Override
	public void updateDataUserGeneral(String id_number, String data_type, String data_phone, String data_address, String iduser) throws Exception {
		// TODO Auto-generated method stub
		if(!id_number.isEmpty()  &&  !data_phone.isEmpty() && !data_address.isEmpty() && !iduser.isEmpty()) {
			repoUser.updateDataUserGeneral(id_number, data_type, data_phone, data_address, iduser);
			throw new Exception("update");
		}else {
			throw new Exception("hay datos vacios");
		}
		
		
	}



	

}
