package com.spg.estore.productservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spg.estore.productservice.core.data.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	ProductEntity findByProductId(String productId);
	
	ProductEntity findByProductIdOrTitle(String productId,String title);
}
