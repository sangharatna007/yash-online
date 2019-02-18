package com.yash.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yash.model.Category;

public class CatogertDaoImpl implements CatogertDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Category> getAllCategory() {
		
		
				// Reading the records from the table
				Session session = sessionFactory.openSession();
				// List<Product> products = session.createQuery("from Product").list();
				List<Category> category = session.createCriteria(Category.class).list();
				System.out.println("----- List of Products-----");
				System.out.println(category);
				// session.flush is used for clear cache in the session
				session.flush();
				// it will close the particular session after completing the process
				session.close();
				return category;
		
	}

	@Override
	public Category getCategoryById(String categoryId) {
		
		// Reading the records from the table
				Session session = sessionFactory.openSession();
				// select * from Category where isbn=i
				Category category = (Category) session.get(Category.class, categoryId);
				session.close();
				return category;
		
	}

	@Override
	public void deleteCategory(String categoryId) {
		
		Session session = sessionFactory.openSession();
		Category category = (Category) session.get(Category.class, categoryId);
		session.delete(category);
		session.flush();
		session.close();
		
		
	}

	@Override
	public void addCategory(Category category) {
		
	}

	@Override
	public void editCategory(Category product) {
		// TODO Auto-generated method stub
		
	}

}
