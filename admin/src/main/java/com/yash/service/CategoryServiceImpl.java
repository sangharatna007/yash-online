package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CatogertDao catogertDao;
	
	@Transactional
	public List getAllcategorys() {
		return catogertDao.getAllcategorys();
	}
	@Transactional
	public Category getcategory(int id) {
		
		return catogertDao.getCategory(id);
	}
	@Transactional
	public category addcategory(Category category) {
		return catogertDao.addCategory(category);
	}

		
	}
	@Transactional
	public void deletecategory(int id) {
		CatogertDao.deletecategory(id);
		
	}

}
