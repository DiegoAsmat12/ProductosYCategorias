package com.diegoasmat.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.diegoasmat.modelos.Category;
import com.diegoasmat.modelos.Product;
import com.diegoasmat.servicios.CategoryService;
import com.diegoasmat.servicios.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/products/new")
	public String renderNewProductForm(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products")
	public String newProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		Product newProduct = productService.crearProducto(product);
		return String.format("redirect:/products/%d",newProduct.getId());
	}
	
	@GetMapping("/products/{product_id}")
	public String productPage(Model model, @PathVariable("product_id")Long id) {
		Product product = productService.obtenerProductoPorId(id);
		
		List<Category> categoriasAEscoger = categoryService.obtenerCategoriasSinProducto(product);
		
		model.addAttribute("product", product);
		model.addAttribute("categorias",categoriasAEscoger);
		return "product.jsp";
	}
	

}
