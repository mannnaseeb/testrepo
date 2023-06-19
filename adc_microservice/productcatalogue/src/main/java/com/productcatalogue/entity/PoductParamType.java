package com.productcatalogue.entity;

import java.io.Serializable;

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
@Table(name = "product_paramtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoductParamType implements Serializable {
	private static final long serialVersionUID = -7026381561686492229L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String caption;
	private String Type;
	private boolean isActive;
}
