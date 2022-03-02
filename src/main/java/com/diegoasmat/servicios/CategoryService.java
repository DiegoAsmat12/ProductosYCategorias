package com.diegoasmat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegoasmat.modelos.Category;
import com.diegoasmat.modelos.Product;
import com.diegoasmat.repositorios.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductService productService;

	public Category crearCategoria(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category obtenerCategoriaPorId(Long id) {
		Optional<Category> categoriaObtenida= categoryRepository.findById(id);
		if(categoriaObtenida.isPresent()) {
			return categoriaObtenida.get();
		}
		return null;
		
	}
	
	public List<Category> obtenerCategoriasEnProducto(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> obtenerCategoriasSinProducto(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public void guardarEnCategoria(Long productId, Long categoryId) {
		Product producto = productService.obtenerProductoPorId(productId);
		Category category = obtenerCategoriaPorId(categoryId);
		
		category.getProducts().add(producto);
		
		categoryRepository.save(category);
	}
}
