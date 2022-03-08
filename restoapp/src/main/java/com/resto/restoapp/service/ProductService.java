package com.resto.restoapp.service;

import com.resto.restoapp.entity.Product;
import com.resto.restoapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(String palabraClave){
    	if(palabraClave != null) {
    		return productRepository.findAll(palabraClave);
    	}
        return productRepository.findAll();
    }
    public void save(Product product){
        productRepository.save(product);
    }
    public Product get(Long id){
        return productRepository.findById(id).get();

    }
    public  void delete(Long id){
        productRepository.deleteById(id);
    }

}
