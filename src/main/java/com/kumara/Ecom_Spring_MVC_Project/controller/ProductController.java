package com.kumara.Ecom_Spring_MVC_Project.controller;


import com.kumara.Ecom_Spring_MVC_Project.model.Product;
import com.kumara.Ecom_Spring_MVC_Project.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    public ProductController(ProductService service) {
        this.service = service;
    }

    ProductService service;


    @RequestMapping("/")
    public String greet(){
        return "Hello World";

    }
    @GetMapping("/products")
    public List<Product> getProducts(){

        return service.getProducts();
    }
}
