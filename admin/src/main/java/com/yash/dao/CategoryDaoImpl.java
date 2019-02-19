package com.yash.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Category> getAllCategory() {
		System.out.println("in Dao");
		Session session = this.sessionFactory.openSession();
		List categoryList = session.createQuery("from Category").list();
		System.out.println("categoryList");
		System.out.println(categoryList);
		return categoryList;
	}

	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category category = (Category) session.load(Category.class, new Integer(id));
		return category;
	}

	public Category addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		return category;
	}

	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);

	}

	public void deleteCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category p = (Category) session.load(Category.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}

}
