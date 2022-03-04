package net.mycrud.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	





}
