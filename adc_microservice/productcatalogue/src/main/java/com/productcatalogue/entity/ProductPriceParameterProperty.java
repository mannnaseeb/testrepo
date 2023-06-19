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
@Table(name = "product_price_parameter_property")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceParameterProperty implements Serializable {
	private static final long serialVersionUID = 6964424503368642594L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String caption;
	private Long createdBy;
	private String dependentColumnName;
	private boolean isActive;
	private Long updatedBy;
	private Date updatedOn;
	private Long dependentPriceParameterId;
	private Long productPriceParameterId;
}
