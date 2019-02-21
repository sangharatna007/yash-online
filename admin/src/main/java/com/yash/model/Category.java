package com.yash.model;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = -1864198348558983648L;

	private int categoryId;

	private String categoryTitle;

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