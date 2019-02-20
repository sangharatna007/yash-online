package com.visitor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_master")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private Integer productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_QUANTITY")
	private Integer productQuantity;
	
	@Column(name="PRODUCT_PRICE")
	private Double productPrice;
	
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="STATUS_FLAG")
	private Integer statusFlag;
	
	
	
	public Product(Integer productId, String productName, Integer productQuantity, Double productPrice,
			Integer categoryId, Integer userId, Integer statusFlag) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.categoryId = categoryId;
		this.userId = userId;
		this.statusFlag = statusFlag;
	}
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", categoryId=" + categoryId + ", userId="
				+ userId + ", statusFlag=" + statusFlag + "]";
	}
}