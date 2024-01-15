package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductForm;
import com.example.demo.service.ProductService;

@RequestMapping("/product")
@org.springframework.stereotype.Controller
public class ProductController {
	
	public final ProductService productService;
	
	@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
	@GetMapping("/all")
	public String viewAllProducts(Model model) {
	    List<Product> products = productService.getAllProducts();
	    model.addAttribute("products", products);
	    return "allProducts";
	}
	
	@GetMapping("/showForm")
	public String showProcutForm() {
		return "saveProduct";
	}


//    @PostMapping("/save")
//    public String saveProduct(@ModelAttribute("productForm") ProductForm productForm,
//                              @AuthenticationPrincipal UserDetails userDetails,
//                              RedirectAttributes redirectAttributes) {
//        
//    	System.out.println("Inside the page");
//    	String username = userDetails.getUsername();
//        productService.saveProduct(productForm, username);
//        redirectAttributes.addFlashAttribute("message", "Product saved successfully.");
//        return "redirect:/all";
//    }
    
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("productForm") ProductForm productForm) {
    	System.out.println("Inside the page");
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        productService.saveProduct(productForm, username);
        return "all";
    }
    
    @PostMapping("/hello")
    public String save() {
    	System.out.println("here");
    	 return "all";
    }

}
