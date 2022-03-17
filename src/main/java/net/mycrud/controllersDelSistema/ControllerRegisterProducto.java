package net.mycrud.controllersDelSistema;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mycrud.implementaciones.ImplementsIServiceUser;
import net.mycrud.implementaciones.ImplementsServiceProduct;
import net.mycrud.model.Product;
import net.mycrud.model.User;
import net.mycrud.saveImgLocal.Utileria;

@Controller
public class ControllerRegisterProducto {

	@Autowired
	private ImplementsIServiceUser ImplementsIServiceUser;

	@Autowired
	private ImplementsServiceProduct implementsServiceProduct;

	// register product Controller
	@GetMapping("/registrar_productos")
	public String registerProducts(Model model, Authentication auth, HttpSession theSession) {
		String correo = auth.getName();
		for (GrantedAuthority rol : auth.getAuthorities()) {
			model.addAttribute("rol", rol.getAuthority());
			// System.out.println("este es el rol " + rol.getAuthority());
		}
		if (theSession.getAttribute("usuario") == null) {
			User usuario = ImplementsIServiceUser.buscarUserporCorreo(correo);
			usuario.setPassword(null);
			theSession.setAttribute("datosUser", usuario);
		}
		return "system/Registrar_productos/RP";
	}

	// save product
	@PostMapping("/saveProduct")
	public String SaveProduct(RedirectAttributes r, @RequestParam("archivoImagen") MultipartFile multiPart, @RequestParam("nombreProducto") String nombreProducto,
			@RequestParam("precio") String precio, @RequestParam("cantidad") String cantidad, @RequestParam("material") String material,
			@RequestParam("precio_X_unidad") String precio_X_unidad) {
  System.out.println("nombre producto " + nombreProducto);
		if (!multiPart.isEmpty()) {
			// String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			String ruta = "C://producto//recursos/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				System.out.println("img subida con exito");
				Product dataProduct = new Product();
				dataProduct.setNombreproducto(nombreProducto);
				dataProduct.setImagen(nombreImagen);
				dataProduct.setPrecio_x_cantidad(precio);
				dataProduct.setCantidad(cantidad);
				dataProduct.setMaterial(material);
				dataProduct.setPrecio_X_unidad(precio_X_unidad);
				implementsServiceProduct.guardarUser(dataProduct);
				r.addFlashAttribute("data", "Producto registrado");
			}
		}
		return "redirect:/registrar_productos";
	}

}
