package com.spg.estore.productservice.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productlookup")
public class ProductLookUpEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3553894765996856114L;
	
	@Id
	private String productId;
	@Column(unique = true)
	private String title;

}
