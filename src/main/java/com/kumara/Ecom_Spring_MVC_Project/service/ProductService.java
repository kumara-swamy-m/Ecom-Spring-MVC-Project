package com.kumara.Ecom_Spring_MVC_Project.service;


import com.kumara.Ecom_Spring_MVC_Project.model.Product;
import com.kumara.Ecom_Spring_MVC_Project.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product getProductsById(int id) {
        return repo.findById(id).orElse(null);
    }


    public Product addProducts(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
       return  repo.save(product);
    }
}
