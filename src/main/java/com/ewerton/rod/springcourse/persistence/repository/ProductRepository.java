package com.ewerton.rod.springcourse.persistence.repository.impl;

import com.ewerton.rod.springcourse.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
