package com.yash.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.model.Category;

@Service("categoryService")
@Transactional
public class CategoryService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public List<Category> getAll(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Category");
		return query.list();
	}
	
	public Category get(Integer categoryId){
		Session session = sessionFactory.getCurrentSession();
		return (Category)session.get(Category.class,categoryId);
	}
	
	public Category getCategoryByName(String categoryName){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.like("categoryName",categoryName));
		
		Object result = criteria.uniqueResult();
		Category category = (Category) result;
		
		return category;
		
	}
	
	public void add(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
	}
	
	public void delete(Integer categoryId){
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category)session.get(Category.class,categoryId);
		session.delete(category);
	}

	public void edit(Category category){
		Session session = sessionFactory.getCurrentSession();
		Category category2 = (Category)session.get(Category.class,category.getCategoryId());
		
		category2.setCategoryName(category.getCategoryName());
		session.save(category2);
	
}
	
}
