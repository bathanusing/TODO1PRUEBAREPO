package com.todo1.hulkstore.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo1.hulkstore.dto.Product;
import com.todo1.hulkstore.entity.ProductMvDc;
import com.todo1.hulkstore.services.ProductServices;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductController {
	
	@Autowired
	ProductServices services;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@GetMapping(value = "/productlist")
	public String showProducts(ModelMap model) {
		model.put("products", services.findAll());
		return "productlist";
	}

	@GetMapping(value = "/addProduct")
	public String showAddProductPage(ModelMap model) {
		model.addAttribute("product", new Product(0, "valor por defecto",
				new BigDecimal(100), "", 10));
		return "product";
	}

	@GetMapping(value = "/delete-product")
	public String deleteProduct(@RequestParam int id) {
		services.deleteByIdProduct(id);
		return "redirect:/productlist";
	}

	@GetMapping(value = "/update-product")
	public String showUpdateProductPage(@RequestParam int id, ModelMap model) throws NotFoundException {
		ProductMvDc product = services.findByIdProduct(id);
		model.put("product", product);
		return "product";
	}

	@PostMapping(value = "/update-product")
	public String updateProduct(ModelMap model, Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "product";
		}
		ProductMvDc productPersistent = new ProductMvDc(product);
		services.saveOrUpdateProduct(productPersistent);
		log.info("Se actualizo producto con exito");
		return "redirect:/productlist";
	}

	@PostMapping(value = "/addProduct")
	public String addProduct(ModelMap model, Product product, BindingResult result) {

		if (result.hasErrors()) {
			return "product";
		}
		ProductMvDc productPersistence = new ProductMvDc(product);
		services.saveOrUpdateProduct(productPersistence);
		log.info("Se agregro producto con exito");
		return "redirect:/productlist";
	}
	
	@GetMapping(value="/findAll")
	public ResponseEntity<List<ProductMvDc>> findAllProducts(){
		return ResponseEntity.ok().body(services.findAll());
	}

}
