package com.productcatalogue.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location_product_mapping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLocationMapEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "DATACENTER_LOCATION_ID")
	private Long datacenterLocationId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_FAMILY_ID")
	private Long productFamilyId;
	
	@Column(name = "PARTNER_ID")
	private Long partnerId;
	
	@Column(name = "PRODUCT_OWNER_TYPE_ID")
	private Long productOwnerTypeId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_FAMILY_NAME")
	private String productFamilyName;
	
	@Column(name = "PRODUCT_CAPTION")
	private String productCaption;
	
	@Column(name = "PRODUCT_FAMILY_CAPTION")
	private String productFamilyCaption;
	
	@Column(name = "IS_ACTIVE")
	private Integer isActive;
	
	@Column(name = "CREATED_ON")
	private String createdOn;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_ON")
	private String updatedOn;
	
	@Column(name = "UPDATED_BY")
	private String modifiedBy;
	
	@Column(name = "IS_FINALIZE")
	private Boolean isFinalized;

}
