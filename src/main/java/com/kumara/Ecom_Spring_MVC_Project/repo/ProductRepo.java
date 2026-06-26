package com.kumara.Ecom_Spring_MVC_Project.repo;

import com.kumara.Ecom_Spring_MVC_Project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
