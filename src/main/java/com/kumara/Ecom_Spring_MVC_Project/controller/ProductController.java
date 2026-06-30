package com.kumara.Ecom_Spring_MVC_Project.controller;


import com.kumara.Ecom_Spring_MVC_Project.model.Product;
import com.kumara.Ecom_Spring_MVC_Project.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping("/product")
    public ResponseEntity<?> addProducts(@RequestPart Product product,
                                         @RequestPart MultipartFile imageFile){

        try{
            Product product1=service.addProducts(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);

        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte []> getImageByyProductId(@PathVariable int productId){
        Product product = service.getProductsById(productId);
        byte [] imageFile = product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product,
                                                     @RequestPart MultipartFile imageFile){
        try {
            Product product1=service.updateProduct(id,product,imageFile);
        }
        catch(Exception e){
            return  new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);

        }
   if(product!=null)
       return new ResponseEntity<>("Updated", HttpStatus.OK);
   else
       return  new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable int id){
        Product product = service.getProductsById(id);
        if(product!=null) {
            service.deleteProducts(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);

        }
        else
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);




    }


}
