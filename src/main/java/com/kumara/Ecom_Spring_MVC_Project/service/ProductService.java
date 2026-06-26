package com.kumara.Ecom_Spring_MVC_Project.service;


import com.kumara.Ecom_Spring_MVC_Project.model.Product;
import com.kumara.Ecom_Spring_MVC_Project.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
         return repo.findAll();
    }
}
