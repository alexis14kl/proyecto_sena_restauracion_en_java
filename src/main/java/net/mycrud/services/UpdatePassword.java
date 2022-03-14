package net.mycrud.services;

import java.util.List;

import net.mycrud.model.User;

public interface UpdatePassword {
	public List<User> buscarPorid(int id) throws Exception;

	void updatePassword(int id, String newpass) throws Exception;}
