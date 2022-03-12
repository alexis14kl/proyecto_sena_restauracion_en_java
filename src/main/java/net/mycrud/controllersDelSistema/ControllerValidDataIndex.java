package net.mycrud.controllersDelSistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mycrud.implementaciones.ImplementsServiceDataGeneral;

@Controller
public class ControllerValidDataIndex {
	
	@Autowired
	private ImplementsServiceDataGeneral implementsServiceDataGeneral;
	
	@GetMapping("/indexValidDate")
	@ResponseBody
	public String ValidatedDataIndexInfoGeneral(@RequestParam("id") String id) throws Exception {
		try {
			implementsServiceDataGeneral.BuscarPorIdData(id);
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
		return null;
	}

}
