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
import org.springframework.web.bind.annotation.RequestParam;

import com.diegoasmat.modelos.Category;
import com.diegoasmat.modelos.Product;
import com.diegoasmat.servicios.CategoryService;
import com.diegoasmat.servicios.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories/new")
	public String renderNewProductForm(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories")
	public String newProduct(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		Category newCategory = categoryService.crearCategoria(category);
		
		return String.format("redirect:/categories/%d",newCategory.getId());
	}
	
	@GetMapping("/categories/{category_id}")
	public String productPage(Model model, @PathVariable("category_id")Long id) {
		Category category = categoryService.obtenerCategoriaPorId(id);
		
		List<Product> productosAEscoger = productService.obtenerProductosSinCategoria(category);
		
		model.addAttribute("category", category);
		model.addAttribute("productos",productosAEscoger);
		return "category.jsp";
	}
	
	@PostMapping("/relacionar")
	public String productCategory(@RequestParam("category_id") Long category_id, @RequestParam("product_id") Long product_id) {
		categoryService.guardarEnCategoria(product_id, category_id);
		Category category = categoryService.obtenerCategoriaPorId(product_id);
		return String.format("redirect:/categories/%d",category.getId());
	}
}
