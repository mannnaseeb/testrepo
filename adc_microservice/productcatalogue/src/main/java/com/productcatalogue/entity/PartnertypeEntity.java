package com.productcatalogue.entity;

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
@Table(name = "partnertype")
public class PartnertypeEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "PARTNER_TYPE")
	private String Name;
	
	@Column(name = "SEQUENCE")
	private Integer sequence;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Column(name = "MODIFIED_BY")
	private String updatedBy;
	
	@Column(name = "MODIFIED_ON")
	private Date updatedOn;

}
