package com.diegoasmat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegoasmat.modelos.Category;
import com.diegoasmat.modelos.Product;
import com.diegoasmat.repositorios.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public Product crearProducto(Product product) {
		return productRepository.save(product);
	}
	
	public Product obtenerProductoPorId(Long id) {
		Optional<Product> productoObtenido= productRepository.findById(id);
		if(productoObtenido.isPresent()) {
			return productoObtenido.get();
		}
		return null;
		
	}
	
	public List<Product> obtenerProductosEnCategoria(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> obtenerProductosSinCategoria(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	
}
