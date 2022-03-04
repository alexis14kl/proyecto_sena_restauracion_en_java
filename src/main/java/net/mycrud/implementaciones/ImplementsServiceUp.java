package net.mycrud.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mycrud.model.UserProfile;
import net.mycrud.repositorios.RepoUP;
import net.mycrud.services.ServiceUP;

@Service
public class ImplementsServiceUp implements ServiceUP {
	
	@Autowired
	private RepoUP repoUP;

	@Override
	public int guardarUp(UserProfile datosup) {
		 int rest = 0;
		 UserProfile u = repoUP.save(datosup);
         if(u.equals(null)) {
        	 rest = 1;
         }
		return 0;
	}

}
