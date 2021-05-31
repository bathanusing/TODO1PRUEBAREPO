package com.todo1.hulkstore.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.entity.ProductMvDc;
import com.todo1.hulkstore.repository.ProductMvDcRepository;
import com.todo1.hulkstore.services.ProductServices;

import javassist.NotFoundException;

@Service
public class ProductServicesImpl implements ProductServices{
	
	@Autowired
	ProductMvDcRepository repository;
	

	@Override
	public ProductMvDc saveOrUpdateProduct(ProductMvDc product) {
		return repository.save(product);
	}

	@Override
	public void deleteProduct(ProductMvDc product) {
		repository.delete(product);
	}
	
	@Override
	  public List<ProductMvDc> findAll() {
	    return StreamSupport.stream(repository.findAll().spliterator(), false)
			    .collect(Collectors.toList());
	  }

	@Override
	public void deleteByIdProduct(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public ProductMvDc findByIdProduct(Integer id) throws NotFoundException {
		Optional<ProductMvDc> product = repository.findById(id);
		product.orElseThrow(()->  new NotFoundException("No se consiguio un producto por este Id"));
		if(product.isPresent()) 
			return product.get();
		return null;
	}
	
	
	
	

}
