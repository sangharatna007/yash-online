package com.visitor.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitor.dao.VisitorDao;
import com.visitor.model.Product;
import com.visitor.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService{
	@Autowired
	private VisitorDao visitorDaoImpl;

	public List<Product> getProductList() {
		return visitorDaoImpl.getProductList();
	}
	
	
}
