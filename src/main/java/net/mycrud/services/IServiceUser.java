package net.mycrud.services;

import java.util.List;

import net.mycrud.model.User;

public interface IServiceUser {
	
	int generatedValue();

	public List<String>buscarCorreo(String email);
	
	public int guardarUser(User datosusuario);
	
	public User buscarUserporCorreo(String correo);
	
	void updateconnect(int conect, String correo);
	
	List<User>searchusers();
	
	List<User>searchusersinaactivos();
	
	public List<User> buscarCorreoxcorreo(String nombre, String pass);
}
