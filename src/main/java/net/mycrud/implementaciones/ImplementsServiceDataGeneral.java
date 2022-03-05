package net.mycrud.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mycrud.model.DataGeneral;
import net.mycrud.repositorios.RepoDataGeneral;
import net.mycrud.services.ServiceDataGeneral;

@Service
public class ImplementsServiceDataGeneral implements ServiceDataGeneral {
	
	@Autowired
	private RepoDataGeneral repoDataGeneral;

	@Override
	public int guardardataG(DataGeneral datosgn) {
		int r = 0;
		DataGeneral datag = repoDataGeneral.save(datosgn);
        if(datag.equals(null)) {
       	 r = 1;
        }
		return 0;
	}

	

	

}
