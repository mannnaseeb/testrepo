package com.productcatalogue.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author praveen.gairola
 *
 */

@Getter
@Setter
@Entity
@Table(name = "location_product_mapping")
public class LocationProductMapping implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DATACENTER_LOCATION_ID")	
	private Long locationId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_FAMILY_ID")
	private Long productFamilyId;
	
	@Column(name = "PARTNER_ID")
	private Long partnerId;
	
	@Column(name = "PRODUCT_OWNER_TYPE_ID")
	private Long ownerTypeId;
	
	@Column(name = "IS_ACTIVE")
	private Integer isActive;
	
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_ON")
	private Date modifiedOn;
	
	@Column(name = "UPDATED_BY")
	private String modifiedBy;
	
	@Column(name = "IS_FINALIZE")
	private boolean isFinalize;

}
