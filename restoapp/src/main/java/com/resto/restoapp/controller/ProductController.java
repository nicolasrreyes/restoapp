package com.resto.restoapp.controller;

import com.resto.restoapp.entity.Product;
import com.resto.restoapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public String Product(Model model, @Param("palabraClave")String palabraClave){
    	
       List<Product> productList =  productService.listAll(palabraClave);
        model.addAttribute("productList", productList);
        model.addAttribute("palabraClave", palabraClave);
                return "product";
    }

    @RequestMapping("/new")
    public String addNewProduct(Model model) {
    	Product product = new Product();
    	model.addAttribute("product", product);
		return "newProduct";
    	
    }
    
    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
    	productService.save(product);
		return "redirect:/product";
    	
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name = "id") Long id) {
    	ModelAndView modelo = new ModelAndView("editProduct");
		
    	Product product = productService.get(id);
    	modelo.addObject("product", product);
    	
    	return modelo;
    	
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name= "id") Long id) {
    	productService.delete(id);
    	return "redirect:/product";
    }
    
    
    
    
}
