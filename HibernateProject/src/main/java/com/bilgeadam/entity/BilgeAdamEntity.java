package com.bilgeadam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "bilge_adam")
public class BilgeAdamEntity implements Serializable {
	private static final long serialVersionUID = -4149516439705226333L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Lob
	private String html;
	
	@Lob
	private String css;
	
	@Lob
	private byte[] picture;
	
	@Column(name = "email", length = 100, nullable = false, unique = false)
	private String email;
	
	// updatable:Güncelleme yapılabilir mi yapılamz mı?
	// insertable:Ekleme yapamazsın
	
	@Column(name = "password", updatable = false)
	private String password;
	
	@Column(name = "specific_value", insertable = false)
	private String specificValue;
	
	@Column(name = "price", columnDefinition = "Decimal (10,2) default'100.00'")
	private double price;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSpecific() {
		return specificValue;
	}
	
	public void setSpecificValue(String specificValue) {
		this.specificValue = specificValue;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getSpecificValue() {
		return specificValue;
	}
	
	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getCss() {
		return css;
	}
	
	public void setCss(String css) {
		this.css = css;
	}
	
	public byte[] getPicture() {
		return picture;
	}
	
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	// getter and setter
	
}
