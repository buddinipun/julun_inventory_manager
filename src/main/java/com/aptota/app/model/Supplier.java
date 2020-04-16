package com.aptota.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import javax.persistence.OneToMany;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@Table(name="supplier")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idsupplier;

	@Column(length=45)
	private String add1;

	@Column(length=45)
	private String add2;

	@Column(length=45)
	private String add3;

	@Column(length=45)
	private String contact1;

	@Column(length=45)
	private String contact2;

	@Column(length=45)
	private String description;

	@Column(length=255)
	private String email;

	@Column(name="supplier_name", length=45)
	private String supplierName;

	//bi-directional many-to-one association to Purchase
	@OneToMany(mappedBy="supplierBean")
	private List<Purchase> purchases;

	public Supplier() {
	}

	public int getIdsupplier() {
		return this.idsupplier;
	}

	public void setIdsupplier(int idsupplier) {
		this.idsupplier = idsupplier;
	}

	public String getAdd1() {
		return this.add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return this.add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return this.add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public String getContact1() {
		return this.contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return this.contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Purchase addPurchas(Purchase purchas) {
		getPurchases().add(purchas);
		purchas.setSupplierBean(this);

		return purchas;
	}

	public Purchase removePurchas(Purchase purchas) {
		getPurchases().remove(purchas);
		purchas.setSupplierBean(null);

		return purchas;
	}

}