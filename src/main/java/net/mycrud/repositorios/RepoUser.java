package net.mycrud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import net.mycrud.dtos.UserDTO;
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
	
	//session by check
	@Query(value = "SELECT u.id,  u.Nombre_completo, u.username, dg.direccion, dg.Telefono, dg.cod_cliente, dg.Numero_cc, dg.tipo_documento FROM usuarios u "
			+ "INNER JOIN datosgenerales dg on u.id = dg.idusuario where username =:correo", nativeQuery = true)
	public List<UserDTO>datosGenerales(String correo);
	
	@Query(value = "select * from usuarios where id =:id", nativeQuery = true)
	public List<User> buscarPorid(int id);
	
	//update info general
	@Modifying
	@Transactional
	@Query(value = "UPDATE datosgenerales "
			+ "SET Numero_cc =:id_number, "
			+ "tipo_documento =:data_type, "
			+ "Telefono  =:data_phone, "
			+ "direccion =:data_address "
			+ "WHERE idusuario =:iduser  ", nativeQuery = true)
	void updateDataUserGeneral(String id_number, String data_type, String data_phone, String data_address, String iduser) throws Exception;;
	


}
