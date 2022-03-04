package net.mycrud.services;

import java.util.List;

import net.mycrud.model.ProfileUser;
import net.mycrud.model.User;
import net.mycrud.model.UserProfile;

public interface IServiceProfile {
	List<ProfileUser>consultarProfile();
}
