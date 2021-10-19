package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.productdao.ProductDAO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDao;
	
	public void saveProduct(Product product) {
		this.productDao.createProduct(product);
	}

	public List<Product> getAllProducts() {
		return this.productDao.getAllProducts();
	}

	public void deleteById(int productId) {
		this.productDao.deleteSingleProduct(productId);
	}

	public Product findById(int productId) {
		return this.productDao.getSingleProduct(productId);
	}

	
}
