package com.productcatalogue.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 6116586075762191199L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long proudctId;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "product_family_id") private ProductFamily productFamily;
	 */
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CAPTION")
	private String caption;
	
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	
	@Column(name = "LONG_DESCRIPTION")
	private String longDescription;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "IS_ACTIVE")
	private Integer isActive;
	
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "MODIFIED_ON")
	private Date modifiedOn;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "PRODUCT_FAMILY_ID")
	private Long productFamilyId;
	
}
