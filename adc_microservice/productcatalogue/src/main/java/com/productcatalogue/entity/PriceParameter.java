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
@Table(name = "price_parameter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceParameter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long createdBy;
	private Date createdOn;
	private boolean isActive;
	private String lookupColumnName;
	private String name;
	private Long similarPriceParameterId;
	private String tableName;
	private Long updatedBy;
	private Date updatedOn;
	private String paramType;
	
}
