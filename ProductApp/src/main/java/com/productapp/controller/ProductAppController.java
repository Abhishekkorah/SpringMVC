package com.productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productapp.model.Product;
import com.productapp.service.ProductService;

@Controller
public class ProductAppController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		
		return "index";
	}

	@RequestMapping("/addproduct")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_Product";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {

		System.out.println("Product : "+ product);
		System.out.println(
				product.getProductName() + "," + product.getProductDescription() + "," + product.getproductPrice());

		this.productService.saveProduct(product);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping("/delete/{productid}")
	public RedirectView deleteProduct(@PathVariable("productid") int productId,HttpServletRequest request) {
		
		this.productService.deleteById(productId);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping(value = "/editproduct/{productid}")
	public String editProduct(@PathVariable("productid") int productId,Model model) {
		
		Product product = this.productService.findById(productId);
		
		System.out.println("Product : "+ product);
		System.out.println(
				product.getProductName() + "," + product.getProductDescription() + "," + product.getproductPrice());
		
		model.addAttribute("product", product);
		
		return "edit_Product";
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(request.getContextPath() + "/edit_Product");
//		return redirectView;
	}
}
