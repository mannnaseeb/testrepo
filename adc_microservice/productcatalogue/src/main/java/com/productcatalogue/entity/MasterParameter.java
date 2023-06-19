package com.productcatalogue.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author praveen.gairola
 *
 */
@Getter
@Setter
public abstract class MasterParameter implements Serializable	{

	private static final long serialVersionUID = 449677773353858423L;
	
	private Long id;
	private String paramterCaptionName;
	private String paramterCode;
	private String paramterShortDesc;
	private String paramterLongDesc;
	private String paramterType;
	private boolean isActive;
	private String createdBy;
	private String createdOn;
	private String modifiedBy;
	private String modifiedOn;
	
}
