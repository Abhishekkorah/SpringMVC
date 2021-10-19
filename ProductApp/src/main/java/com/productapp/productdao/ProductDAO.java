package com.productapp.productdao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.productapp.model.Product;

@Component
public class ProductDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//---------Save a Product-------------\\
	@Transactional
	public void createProduct(Product product) {
//		this.hibernateTemplate.save(product);
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	//----------Get all Products------------\\
	public List<Product> getAllProducts(){
		return this.hibernateTemplate.loadAll(Product.class);
	}
	
	//----------Get Single Product------------\\
	public Product getSingleProduct(int id) {
		return this.hibernateTemplate.get(Product.class, id);
	}
	
	//----------Delete Single Product------------\\
	@Transactional
	public void deleteSingleProduct(int id) {
		Product product = this.hibernateTemplate.load(Product.class, id);
		this.hibernateTemplate.delete(product);
	}
}
