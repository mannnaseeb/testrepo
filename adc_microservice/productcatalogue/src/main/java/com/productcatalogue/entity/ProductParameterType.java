package com.productcatalogue.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 
 * @author praveen.gairola
 *
 */
@Entity
@Table(name = "product_parameter_type")
@NoArgsConstructor
@AllArgsConstructor
public class ProductParameterType extends MasterParameter implements Serializable{

	private static final long serialVersionUID = 2496328324586689679L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String caption;
	private Long createdBy;
	private Date createdOn;
	private boolean isActive;
	private String name;
	private Long updatedBy;
	private Date updatedOn;
}
