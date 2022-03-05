package net.mycrud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import net.mycrud.model.User;

public interface RepoUser extends CrudRepository<User, Integer> {
	
	//auto generatedValue id
			@Query(value = "select round( rand()*1000000)", nativeQuery = true)
			int generatedValue();

	// search email
	@Query(value = " select * from usuarios where username =:email", nativeQuery = true)
	public List<String> buscarCorreo(String email);

	User findByUsername(String correo);

	// update campus connect
	@Modifying
	@Transactional
	@Query(value = "UPDATE usuarios SET conect =:conect  " + " WHERE usuarios.username=:correo ", nativeQuery = true)
	void updateconnect(int conect, String correo);

	// *users activos
	@Query(value = " SELECT * from usuarios u " + "					JOIN usuarioperfil up "
			+ "                    on u.id = up.idusuario " + "					join perfiles p "
			+ "                    on up.idperfil = p.id "
			+ "                    WHERE u.conect = 1 ", nativeQuery = true)
	List<User> searchusers();

	// *users inaactivos
	@Query(value = " SELECT * from usuarios u " + "					JOIN usuarioperfil up "
			+ "                    on u.id = up.idusuario " + "					join perfiles p "
			+ "                    on up.idperfil = p.id "
			+ "                    WHERE u.conect = 0 ", nativeQuery = true)
	List<User> searchusersinaactivos();
	

	
	@Query(value = "select * from usuarios where username =:nombre and password =:pass", nativeQuery = true)
	public List<User> buscarCorreoxcorreo(String nombre, String pass);

}
