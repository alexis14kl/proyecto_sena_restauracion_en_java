package net.mycrud.services;

import java.util.List;

import net.mycrud.model.DataGeneral;

public interface ServiceDataGeneral {
	
	public int guardardataG(DataGeneral datosgn);
	//search data to modal
	DataGeneral BuscarPorIdData(String id) throws Exception;}
