package com.spg.estore.productservice.command;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spg.estore.productservice.core.data.ProductLookUpEntity;
import com.spg.estore.productservice.core.event.ProductCreatedEvent;
import com.spg.estore.productservice.core.repository.ProductLookUpRepository;

@Component
@ProcessingGroup("product-group")
public class ProductLookUpEventHandler {

	@Autowired
	private ProductLookUpRepository productLookUpRepository;
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		ProductLookUpEntity productLookUpEntity = new ProductLookUpEntity(event.getProductId(),event.getTitle());;
		productLookUpRepository.save(productLookUpEntity);
	}
}
