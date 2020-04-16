package com.aptota.app.model.requests;

import java.util.List;

import com.aptota.app.model.order.ViewQuotation;
import com.aptota.app.model.response.GetQuotationItem;

public class QuotationReportReqest {
	
	private ViewQuotation viewQuotation;
	private List<GetQuotationItem> orderItemList;
	
	
	
	
	public QuotationReportReqest(ViewQuotation viewQuotation, List<GetQuotationItem> orderItemList) {
		super();
		this.viewQuotation = viewQuotation;
		this.orderItemList = orderItemList;
	}
	public ViewQuotation getViewQuotation() {
		return viewQuotation;
	}
	public void setViewQuotation(ViewQuotation viewQuotation) {
		this.viewQuotation = viewQuotation;
	}
	public List<GetQuotationItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<GetQuotationItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	
	
	

}
