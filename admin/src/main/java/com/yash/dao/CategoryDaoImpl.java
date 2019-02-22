package com.yash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Category> getAllCategories() {
		List<Category> categories = jdbcTemplate.query("SELECT * FROM category",
				new BeanPropertyRowMapper(Category.class));
		return categories;
	}

	public Category getCategoryById(int id) {
		Category category = (Category) jdbcTemplate.queryForObject("SELECT * FROM category where categoryid = ? ",
				new Object[] { id }, new BeanPropertyRowMapper(Category.class));

		return category;
	}

	public void addCategory(Category category) {
		jdbcTemplate.update("INSERT INTO category (categoryId, categoryTitle) VALUES (?, ?)", category.getCategoryId(),
				category.getCategoryTitle());

	}

	public void updateCategory(Category category) {
		jdbcTemplate.update("UPDATE category SET categoryTitle = ?  WHERE categoryId = ? ", category.getCategoryTitle(),
				category.getCategoryId());

	}

	public void deleteCategory(int id) {
		jdbcTemplate.update("DELETE from category WHERE categoryId = ? ", id);
	}

	public boolean exists(Category category) {

		return getCategoryByName(category.getCategoryTitle()) != null;
	}

	public Category getCategoryByName(String name) {

		Category category = (Category) jdbcTemplate.queryForObject("SELECT * FROM category where categoryTitle = ? ",
				new Object[] { name }, new BeanPropertyRowMapper(Category.class));

		return category;
	}

}