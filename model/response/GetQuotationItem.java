package com.aptota.app.model.response;

public class GetQuotationItem {

    String itemCode;
    String itemName;
    Integer quotationItemId;
    double amount;
    Integer ItemRefId;
    Integer quantity;
    String itemDesciption;
    String basePrice;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuotationItemId() {
        return quotationItemId;
    }

    public void setQuotationItemId(Integer quotationItemId) {
        this.quotationItemId = quotationItemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getItemRefId() {
        return ItemRefId;
    }

    public void setItemRefId(Integer itemRefId) {
        ItemRefId = itemRefId;
    }

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getItemDesciption() {
		return itemDesciption;
	}

	public void setItemDesciption(String itemDesciption) {
		this.itemDesciption = itemDesciption;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	
	
    
}
