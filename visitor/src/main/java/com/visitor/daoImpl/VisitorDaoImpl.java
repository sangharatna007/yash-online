package com.visitor.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.visitor.dao.VisitorDao;
import com.visitor.model.Product;

@Repository
public class VisitorDaoImpl implements VisitorDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	public List<Product> getProductList() {
		Session session = this.sessionFactory.openSession();
		List productList = session.createQuery("from Product").list();
		return productList;
	}
	
}
