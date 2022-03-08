package com.resto.restoapp.repository;

import com.resto.restoapp.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository <Product, Long> {

@Query("SELECT p FROM Product p WHERE "
		+ " CONCAT(p.id,p.name,p.description,p.type,p.price)"
		+ " LIKE %?1%")
public List<Product> findAll(String palabraClave);

}
