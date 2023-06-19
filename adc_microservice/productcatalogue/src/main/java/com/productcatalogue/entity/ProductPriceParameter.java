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
@Table(name = "product_price_parameter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceParameter implements Serializable {
	private static final long serialVersionUID = -1647199589558995541L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String caption;
	private Long createdBy;
	private Date createdOn;
	private boolean isActive;
	private String lookupQuery;
	private String productName;
	private Long product_id;
	private String tableName;
	private Long updatedBy;
	private Date updatedOn;
	private Long priceParameterId;
	private Long priceParameterDirectionId;
	private Long productParameterTypeId;
	private Long parentPriceParameterId;
	private Long productPriceSearchInputMethodId;
	private Integer isDescParameter;
	private Integer isGroupParameter;
	private Integer groupSequence;
	private Integer isPdfDescParameter;
	private String helpQuery;
	private String customerLookupQuery;
	private Integer isNonStandard;
	private Long descriptionTypeId;
	private String displayCaption;
	private String paramType;
	private Integer isCopyParameter;
}
