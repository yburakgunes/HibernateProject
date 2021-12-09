package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

// indexes = {@Index}
@Entity
@Table(name = "eticaret", indexes = { @Index(columnList = "id", name = "BILGEADAM_INDEX", unique = true) })
public class ETicaretEntity implements Serializable {
	private static final long serialVersionUID = -8246449115554650968L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "price", columnDefinition = "Decimal(10,2)")
	private double price;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_color")
	private String productColor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date date;
	
	public ETicaretEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public ETicaretEntity(int id, double price, String productName, String productColor) {
		super();
		this.id = id;
		this.price = price;
		this.productName = productName;
		this.productColor = productColor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductColor() {
		return productColor;
	}
	
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
