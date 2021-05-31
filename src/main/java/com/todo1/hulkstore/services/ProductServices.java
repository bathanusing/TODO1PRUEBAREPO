package com.todo1.hulkstore.services;

import java.util.List;

import com.todo1.hulkstore.entity.ProductMvDc;

import javassist.NotFoundException;

public interface ProductServices {
	
	public ProductMvDc saveOrUpdateProduct(ProductMvDc product);

	  public void deleteProduct(ProductMvDc product);
	  
	  
	  public List<ProductMvDc> findAll();
	  
	  public void deleteByIdProduct(Integer id);
	  
	  public ProductMvDc findByIdProduct(Integer id) throws NotFoundException;

}
