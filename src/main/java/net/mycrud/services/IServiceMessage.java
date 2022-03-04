package net.mycrud.services;

import java.util.List;

import net.mycrud.model.Message;
import net.mycrud.model.User;

public interface IServiceMessage {
	public String guardarMensage(Message mensage);
	List<Message>seachMessages(String id);
}
