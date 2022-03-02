package com.diegoasmat.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegoasmat.modelos.Category;
import com.diegoasmat.modelos.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAllByCategories(Category category);
	
	List<Product> findByCategoriesNotContains(Category category);
	
}
