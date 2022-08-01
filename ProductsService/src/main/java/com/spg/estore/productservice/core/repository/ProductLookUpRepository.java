package com.spg.estore.productservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spg.estore.productservice.core.data.ProductLookUpEntity;

public interface ProductLookUpRepository extends JpaRepository<ProductLookUpEntity, String> {
	
	ProductLookUpEntity findByProductIdOrTitle(String productId,String title);

}
