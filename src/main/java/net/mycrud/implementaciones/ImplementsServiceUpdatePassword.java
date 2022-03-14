package net.mycrud.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mycrud.model.User;
import net.mycrud.repositorios.RepoUser;
import net.mycrud.services.UpdatePassword;

@Service
public class ImplementsServiceUpdatePassword implements UpdatePassword{
	
	@Autowired
	private RepoUser repoUser;

	@Override
	public List<User> buscarPorid(int id) throws Exception {
		List<User>data =repoUser.buscarPorid(id);
		if(data.isEmpty()) {
			System.out.println("no hay data");
			throw new Exception("no hay info");
		}else {
			
			System.out.println("si hay data");
			
			throw new Exception("ok + " + data);
		}
	}

	@Override
	public void updatePassword(int id, String newpass) throws Exception {
		
		if(newpass.isEmpty()) {
			throw new Exception("campo vacio 1");
		}else {
				repoUser.updatePassword(id, newpass);
				throw new Exception("contraseña ok");
			}
			
		}
}


