package com.yash.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Category;
import com.yash.model.Product;
import com.yash.service.CategoriesService;
import com.yash.utils.Constants;

/**
 * @author manish.dugaya
 *
 */
@RestController
public class BuyerController {
	private static final Logger log = Logger.getLogger(BuyerController.class);

	@Autowired
	private CategoriesService categoriesServiceImpl;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/category")
	public ResponseEntity getAllCategory() {
		log.info("****inside category handler*****");
		List<Category> categoryList = categoriesServiceImpl.getAllCategory();
		log.info("****inside category handler categoryList*****"+categoryList);
		if (null == categoryList||categoryList.size()==0)
				return new ResponseEntity(Constants.NO_CATEGORY_PRESENT, HttpStatus.NOT_ACCEPTABLE);
		return	new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/category/{id}")
	public ResponseEntity getProductUnderCategoryById(@PathVariable Integer id) {
		log.info("****inside getProductUnderCategoryById handler***** " +id);
		if(null==id||id<0)
			return new ResponseEntity(Constants.PLEASE_SELECT_RIGHT_PRODUCT, HttpStatus.BAD_REQUEST);
		List<Product> productListUnderCategory = categoriesServiceImpl.getProductUnderCategory(id);
		log.info("****inside getProductUnderCategoryById handler productListUnderCategory ***** " +productListUnderCategory);
		if (null == productListUnderCategory ||productListUnderCategory.size()==0)
				return new ResponseEntity(Constants.NO_PRODUCT_PRESENT_UNDER_SELECTED_CATEGORY, HttpStatus.NOT_ACCEPTABLE);
		return	new ResponseEntity<List<Product>>(productListUnderCategory, HttpStatus.OK);
	}
}
