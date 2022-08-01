package com.spg.estore.productservice.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spg.estore.productservice.core.data.ProductEntity;
import com.spg.estore.productservice.core.repository.ProductRepository;
import com.spg.estore.productservice.query.rest.ProductRestModel;

@Component
@ProcessingGroup("product-group")
public class ProductsQueryHandler {

	@Autowired
	private ProductRepository productRepository;

	@QueryHandler
	public List<ProductRestModel> findProducts(FindProductsQuery query) {
		List<ProductRestModel> productsRest = new ArrayList<>();
		List<ProductEntity> productEntities = productRepository.findAll();
		productEntities.stream().forEach(productEntity -> {
			ProductRestModel productRestModel = new ProductRestModel();
			BeanUtils.copyProperties(productEntity, productRestModel);
			productsRest.add(productRestModel);
		});
		return productsRest;
	}
}
