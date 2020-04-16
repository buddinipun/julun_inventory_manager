package com.aptota.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@Table(name="item")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iditem;

	private Integer amount;

	@Column(name="item_code", length=25)
	private String itemCode;

	@Column(name="item_description", length=255)
	private String itemDescription;

	@Column(name="message", length=45)
	private String message;

	@Column(name="item_type", length=45)
	private String itemType;
	
	
	@Column(name="dealer_price")
	private Double dealerPrice;
	
	@Column(name="customer_price")
	private Double customerPrice;
	
	@Column (name="distributer_price")
	private Double distributerPrice;
	
	@Column (name="meater_value")
	private Double meaterValue;
	
	@Column (name="item_wave")
	private Integer itemWave;
	
	
	
	

	//bi-directional many-to-one association to Purchase
	@JsonIgnore
	@OneToMany(mappedBy="item")
	private List<Purchase> purchases;

	//bi-directional many-to-one association to Sale
	@JsonIgnore
	@OneToMany(mappedBy="item")
	private List<Sale> sales;

	public Item() {
	}

	public int getIditem() {
		return this.iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	

	public Double getDealerPrice() {
		return dealerPrice;
	}

	public void setDealerPrice(Double dealerPrice) {
		this.dealerPrice = dealerPrice;
	}

	public Double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(Double customerPrice) {
		this.customerPrice = customerPrice;
	}
	
	public Double getDistributerPrice() {
		return distributerPrice;
	}

	public void setDistributerPrice(Double distributerPrice) {
		this.distributerPrice = distributerPrice;
	}

	public Double getMeaterValue() {
		return meaterValue;
	}

	public void setMeaterValue(Double meaterValue) {
		this.meaterValue = meaterValue;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Purchase addPurchas(Purchase purchas) {
		getPurchases().add(purchas);
		purchas.setItem(this);

		return purchas;
	}

	public Purchase removePurchas(Purchase purchas) {
		getPurchases().remove(purchas);
		purchas.setItem(null);

		return purchas;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setItem(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setItem(null);

		return sale;
	}

	public Integer getItemWave() {
		return itemWave;
	}

	public void setItemWave(Integer itemWave) {
		this.itemWave = itemWave;
	}

	
	
	

}