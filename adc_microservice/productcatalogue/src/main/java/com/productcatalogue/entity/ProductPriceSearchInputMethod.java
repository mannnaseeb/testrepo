package com.productcatalogue.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author praveen.gairola
 *
 */
@Entity
@Table(name = "product_price_search_input_method")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceSearchInputMethod implements Serializable {
	private static final long serialVersionUID = -7623036693335375607L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String caption;
	private Long createdBy;
	private boolean isActive;
	private String name;
	private Long updatedBy;
	private Date updatedOn;
}
