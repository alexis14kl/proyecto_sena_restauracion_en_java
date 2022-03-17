package net.mycrud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.mycrud.model.Product;

public interface RepoProduct extends JpaRepository<Product, Integer> {
	
	@Query(value="SELECT * FROM productos", nativeQuery=true)
	List<Product>BuscarProduct();

}
