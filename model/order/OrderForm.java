package com.aptota.app.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderForm {
	
    OrderItemList orderList;
	private Date expDeliveryDate;
	private String quatationType;
	private String orderType;
	public OrderItemList getOrderList() {
		return orderList;
	}
	public void setOrderList(OrderItemList orderList) {
		this.orderList = orderList;
	}
	public Date getExpDeliveryDate() {
		return expDeliveryDate;
	}
	public void setExpDeliveryDate(Date expDeliveryDate) {
		this.expDeliveryDate = expDeliveryDate;
	}
	public String getQuatationType() {
		return quatationType;
	}
	public void setQuatationType(String quatationType) {
		this.quatationType = quatationType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	
	
	
	
}
