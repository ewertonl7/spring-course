package com.ewerton.rod.springcourse.service;

import com.ewerton.rod.springcourse.dto.SaveCategory;
import com.ewerton.rod.springcourse.dto.SaveProduct;
import com.ewerton.rod.springcourse.persistence.entity.Category;
import com.ewerton.rod.springcourse.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findOneById(Long productId);

    Category createOne(SaveCategory saveProduct);

    Category updateOneById(Long productId, SaveCategory saveProduct);

    Category disableOneById(Long productId);
}
