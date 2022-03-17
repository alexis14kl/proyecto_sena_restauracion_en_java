package net.mycrud.services;

import java.util.List;

import net.mycrud.model.Product;

public interface IServeceProduct {
	public int guardarUser(Product dataProduct);
	List<Product>BuscarProduct();
}
