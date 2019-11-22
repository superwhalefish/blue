package com.yy.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer>,JpaSpecificationExecutor<Product>{

}
