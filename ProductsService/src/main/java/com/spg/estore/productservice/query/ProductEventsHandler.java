package com.spg.estore.productservice.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spg.estore.productservice.core.data.ProductEntity;
import com.spg.estore.productservice.core.event.ProductCreatedEvent;
import com.spg.estore.productservice.core.repository.ProductRepository;

@Component
public class ProductEventsHandler {

	@Autowired
	private ProductRepository productRepository;
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		ProductEntity productEntity= new ProductEntity();
		BeanUtils.copyProperties(event, productEntity);
		productRepository.save(productEntity);
	}
}
