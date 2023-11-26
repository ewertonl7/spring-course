package com.ewerton.rod.springcourse.persistence.repository;

import com.ewerton.rod.springcourse.persistence.entity.Category;
import com.ewerton.rod.springcourse.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
