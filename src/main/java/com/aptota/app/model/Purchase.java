package com.aptota.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the purchase database table.
 * 
 */
@Entity
@Table(name="purchase")
@NamedQuery(name="Purchase.findAll", query="SELECT p FROM Purchase p")
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idpurchase;

	private int amount;

	@Column(name="grn_code", length=45)
	private String grnCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="purchase_date")
	private Date purchaseDate;

	@Column(name="unit_price")
	private int unitPrice;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier")
	private Supplier supplierBean;

	public Purchase() {
	}

	public int getIdpurchase() {
		return this.idpurchase;
	}

	public void setIdpurchase(int idpurchase) {
		this.idpurchase = idpurchase;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getGrnCode() {
		return this.grnCode;
	}

	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Supplier getSupplierBean() {
		return this.supplierBean;
	}

	public void setSupplierBean(Supplier supplierBean) {
		this.supplierBean = supplierBean;
	}

}