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
@Table(name = "price_parameter_direction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceParameterDirection implements Serializable {
	private static final long serialVersionUID = -2797998938679671101L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long createdBy;
	private Date createdOn;
	private boolean isActive;
	private Long updatedBy;
	private Date updatedOn;
}
