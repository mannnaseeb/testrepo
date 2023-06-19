package com.loyaltyservice.model.response;

import java.util.List;

public class PartnerDetailResponse{
    public boolean success;
    public Long total;
    public String message;
    public List<PartnerData> data;
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<PartnerData> getData() {
		return data;
	}
	public void setData(List<PartnerData> data) {
		this.data = data;
	}
    
    
    
}
