package net.mycrud.implementaciones;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mycrud.model.Message;
import net.mycrud.model.User;
import net.mycrud.repositorios.RepoMessage;
import net.mycrud.services.IServiceMessage;

@Service
public class ImplementsServiceMessage implements IServiceMessage {
	
	@Autowired
	private RepoMessage repoMessage;

	@Override
	public String guardarMensage(Message mensage) {
		String resultado = "a";
		Message m = repoMessage.save(mensage);
		
		if(m.equals(null)) {
			resultado = "b";
		}
		return resultado;
	}

	@Override
	public List<Message> seachMessages(String id) {
		   List<Message> l = repoMessage.seachMessages(id);
		return l;
	}



	



	
	



}
