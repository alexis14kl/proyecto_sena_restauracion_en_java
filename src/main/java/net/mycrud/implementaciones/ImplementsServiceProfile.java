package net.mycrud.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mycrud.model.ProfileUser;
import net.mycrud.model.User;
import net.mycrud.model.UserProfile;
import net.mycrud.repositorios.RepoProfileUser;
import net.mycrud.services.IServiceProfile;

@Service
public class ImplementsServiceProfile implements IServiceProfile {
	@Autowired
	private RepoProfileUser RepoProfileUser;
	
	@Override
	public List<ProfileUser> consultarProfile() {
		List<ProfileUser> resultadoProfile = RepoProfileUser.consultarProfile();
		return resultadoProfile;
	}

}
