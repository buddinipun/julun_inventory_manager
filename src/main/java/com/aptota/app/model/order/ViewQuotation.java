package com.aptota.app.model.order;

import java.sql.Date;

public class ViewQuotation {

    private String customerName;
    private Date createDate;
    private Date expectedDelivery;
    private String marketingexeName;
    private String quotationType;
    private int quotationId;
    private Double TotalValue;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public String getMarketingexeName() {
        return marketingexeName;
    }

    public void setMarketingexeName(String marketingexeName) {
        this.marketingexeName = marketingexeName;
    }

    public String getQuotationType() {
        return quotationType;
    }

    public void setQuotationType(String quotationType) {
        this.quotationType = quotationType;
    }

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

	public Double getTotalValue() {
		return TotalValue;
	}

	public void setTotalValue(Double totalValue) {
		TotalValue = totalValue;
	}
    
}
