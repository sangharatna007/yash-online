package com.yash.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yash.utils.Constants;


/**
 * @author manish.dugaya
 *
 */
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1864198348558983648L;

	@NotNull(message = Constants.PLEASE_PROVIDE_CATEGORY_ID)
	private int categoryId;
	@NotNull(message = Constants.PLEASE_PROVIDE_CATEGORY_TYPE)
	private String categoryType;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryType=" + categoryType + "]";
	}

	public Category(int categoryId, String categoryType) {
		super();
		this.categoryId = categoryId;
		this.categoryType = categoryType;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
