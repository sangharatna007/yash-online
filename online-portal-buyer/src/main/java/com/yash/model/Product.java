package com.yash.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yash.utils.Constants;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_PRODUCT_ID)
	private Integer productId;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_PRODUCT_NAME)
	private String productName;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_PRODUCT_QUANTITY)
	private Integer productQuantity;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_PRODUCT_PRICE)
	private Double productPrice;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_CATEGORY_ID)
	private Integer categoryId;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_USER_ID)
	private Integer userId;
	
	@NotNull(message=Constants.PLEASE_PROVIDE_STATUS_FLAG)
	private Integer statusFlag;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
		result = prime * result + ((statusFlag == null) ? 0 : statusFlag.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (productQuantity == null) {
			if (other.productQuantity != null)
				return false;
		} else if (!productQuantity.equals(other.productQuantity))
			return false;
		if (statusFlag == null) {
			if (other.statusFlag != null)
				return false;
		} else if (!statusFlag.equals(other.statusFlag))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", categoryId=" + categoryId + ", userId="
				+ userId + ", statusFlag=" + statusFlag + "]";
	}

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

	
	

	
}