package net.mycrud.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.mycrud.model.ProfileUser;

@Repository
public interface RepoProfileUser extends JpaRepository<ProfileUser, Integer> {
	
	@Query(value = "SELECT * FROM perfiles" , nativeQuery = true)
	List<ProfileUser>consultarProfile();

}
