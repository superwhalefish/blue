package com.yy.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.ProductCategroy;

public interface ProductCategroyRepositry extends JpaRepository<ProductCategroy, Integer>,JpaSpecificationExecutor<ProductCategroy>{

}
