package net.mycrud.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mycrud.model.Product;
import net.mycrud.repositorios.RepoProduct;
import net.mycrud.services.IServeceProduct;

@Service
public class ImplementsServiceProduct implements IServeceProduct {
	
	@Autowired
	private RepoProduct repoProduct;

	@Override
	public int guardarUser(Product dataProduct) {
		repoProduct.save(dataProduct);
		return 0;
	}

	@Override
	public List<Product> BuscarProduct() {
		return repoProduct.BuscarProduct();
	}

}
