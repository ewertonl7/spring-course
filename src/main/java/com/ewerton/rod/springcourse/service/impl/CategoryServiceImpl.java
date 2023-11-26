package com.ewerton.rod.springcourse.service.impl;

import com.ewerton.rod.springcourse.dto.SaveCategory;
import com.ewerton.rod.springcourse.dto.SaveProduct;
import com.ewerton.rod.springcourse.exception.ObjectNotFoundException;
import com.ewerton.rod.springcourse.persistence.entity.Category;
import com.ewerton.rod.springcourse.persistence.entity.Product;
import com.ewerton.rod.springcourse.persistence.repository.CategoryRepository;
import com.ewerton.rod.springcourse.service.CategoryService;
import com.ewerton.rod.springcourse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createOne(SaveCategory saveCategory) {

        Category category = new Category();
        category.setName(saveCategory.getName());
        category.setStatus(Category.CategoryStatus.ENABLED);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {

        Category categoryFromDB = categoryRepository.findById(categoryId)
                .orElseThrow( () -> new ObjectNotFoundException("Category not found with id: " + categoryId));

        categoryFromDB.setName(saveCategory.getName());

        return categoryRepository.save(categoryFromDB);
    }

    @Override
    public Category disableOneById(Long categoryId) {
        Category categoryFromDB = categoryRepository.findById(categoryId)
                .orElseThrow( () -> new ObjectNotFoundException("Category not found with id: " + categoryId));

        categoryFromDB.setStatus(Category.CategoryStatus.DISABLED);

        return categoryRepository.save(categoryFromDB);
    }
}
