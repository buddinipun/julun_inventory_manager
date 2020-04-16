package com.aptota.app.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the sales database table.
 * 
 */
@Entity
@Table(name="sales")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idsale;

	private int amount;

	@Column(length=45)
	private String date;

	private int discount;

	@Column(name="invoice_id", length=45)
	private String invoiceId;

	@Column(length=45)
	private String salsesby;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="product_id")
	private Item item;

	public Sale() {
	}

	public int getIdsale() {
		return this.idsale;
	}

	public void setIdsale(int idsale) {
		this.idsale = idsale;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getSalsesby() {
		return this.salsesby;
	}

	public void setSalsesby(String salsesby) {
		this.salsesby = salsesby;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}