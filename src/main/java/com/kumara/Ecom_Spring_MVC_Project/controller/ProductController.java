package com.kumara.Ecom_Spring_MVC_Project.controller;


import com.kumara.Ecom_Spring_MVC_Project.model.Product;
import com.kumara.Ecom_Spring_MVC_Project.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
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
    public ResponseEntity<List<Product>> getProducts(){

        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public  ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = service.getProductsById(id);
        if(product!=null)
        return new ResponseEntity<>(product,HttpStatus.OK) ;
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
