
package com.yash.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.dao.CategoriesDao;
import com.yash.model.Category;
import com.yash.model.Product;

/**
 * @author manish.dugaya
 *
 */
@Repository
public class CategoriesDaoImpl implements CategoriesDao {

	private static final Logger log = Logger.getLogger(CategoriesDaoImpl.class);
	
	private  static final String SELECT_FROM_PRODUCT_WHERE_CATEGORY="SELECT * FROM PRODUCT_MASTER WHERE CATEGORY_ID=? AND STATUS_FLAG=1";
	private  static final String SELECT_FROM_CATEGORY="SELECT * FROM CATEGORY_MASTER";

	@Autowired
    JdbcTemplate jdbcTemplate;
	

	public List<Product> getProductUnderCategory(int categoryId) {
		log.info("******getProductUnderCategory DAO****categoryId*** "+categoryId);
		return jdbcTemplate.query(SELECT_FROM_PRODUCT_WHERE_CATEGORY,new Object[] {categoryId },new BeanPropertyRowMapper<Product>(Product.class));
	}

	public List<Category> getAllCategory() {
		
		return jdbcTemplate.query(SELECT_FROM_CATEGORY,new BeanPropertyRowMapper<Category>(Category.class));
	}

}
