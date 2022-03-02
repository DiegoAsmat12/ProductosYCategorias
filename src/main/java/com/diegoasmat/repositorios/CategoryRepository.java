package com.diegoasmat.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegoasmat.modelos.Category;
import com.diegoasmat.modelos.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	// Recupera una lista de todas las categorías para un producto en particular
	List<Category> findAllByProducts(Product product);
	// Recupera una lista de cualquier categoría a la que un producto en particular
    // no pertenece.
	List<Category> findByProductsNotContains(Product product);
	
	
}
