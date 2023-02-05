package com.pushpraj.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pushpraj.springcloud.model.Product;

public interface productRepo extends JpaRepository<Product, Long> {

}
