package com.yash.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Category implements Serializable {

	private static final long serialVersionUID = -1864198348558983648L;

	@NotNull
	private int categoryId;

	@NotNull
	private String categoryTitle;
	
	public Category(){}

	public Category(int id, String title) {
		this.categoryId = id;
		this.categoryTitle = title;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

}