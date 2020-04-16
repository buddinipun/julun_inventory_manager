package com.aptota.app.model;
// Generated Mar 26, 2020 3:57:56 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ItemDaily generated by hbm2java
 */
@Entity
@Table(name = "item_daily", catalog = "restaurent_erp")
public class ItemDaily implements java.io.Serializable {

	private Integer idItemDaily;
	private Integer itemId;
	private Double dayStartbalance;
	private Double dayEndBalance;
	private Date date;
	private Double wastageQuantity;

	public ItemDaily() {
	}

	public ItemDaily(Integer itemId, Double dayStartbalance, Double dayEndBalance, Date date, Double wastageQuantity) {
		this.itemId = itemId;
		this.dayStartbalance = dayStartbalance;
		this.dayEndBalance = dayEndBalance;
		this.date = date;
		this.wastageQuantity = wastageQuantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_item_daily", unique = true, nullable = false)
	public Integer getIdItemDaily() {
		return this.idItemDaily;
	}

	public void setIdItemDaily(Integer idItemDaily) {
		this.idItemDaily = idItemDaily;
	}

	@Column(name = "item_id")
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "day_startbalance", precision = 22, scale = 0)
	public Double getDayStartbalance() {
		return this.dayStartbalance;
	}

	public void setDayStartbalance(Double dayStartbalance) {
		this.dayStartbalance = dayStartbalance;
	}

	@Column(name = "day_end_balance", precision = 22, scale = 0)
	public Double getDayEndBalance() {
		return this.dayEndBalance;
	}

	public void setDayEndBalance(Double dayEndBalance) {
		this.dayEndBalance = dayEndBalance;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date", length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "wastage_quantity", precision = 22, scale = 0)
	public Double getWastageQuantity() {
		return this.wastageQuantity;
	}

	public void setWastageQuantity(Double wastageQuantity) {
		this.wastageQuantity = wastageQuantity;
	}

}
