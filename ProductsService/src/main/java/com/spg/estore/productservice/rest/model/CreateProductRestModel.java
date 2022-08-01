package com.spg.estore.productservice.rest.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRestModel {

	@NotBlank(message="Title is Mandatory")
	private String title;
	private BigDecimal price;
	private Integer quantity;
	
}
