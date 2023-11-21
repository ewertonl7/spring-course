package com.ewerton.rod.springcourse.controller;

import com.ewerton.rod.springcourse.dto.SaveCategory;
import com.ewerton.rod.springcourse.dto.SaveProduct;
import com.ewerton.rod.springcourse.persistence.entity.Category;
import com.ewerton.rod.springcourse.persistence.entity.Product;
import com.ewerton.rod.springcourse.service.CategoryService;
import com.ewerton.rod.springcourse.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable){
        Page<Category> categoriesPage = categoryService.findAll(pageable);

        if(categoriesPage.hasContent()){
            return ResponseEntity.ok(categoriesPage);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findOneById(@PathVariable Long categoryId){
        Optional<Category> productPageOpt = categoryService.findOneById(categoryId);

        if(productPageOpt.isPresent()){
            return ResponseEntity.ok(productPageOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> createOne(@RequestBody @Valid SaveCategory saveCategory){
        Category category = categoryService.createOne(saveCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateOneById(@PathVariable Long categoryId,
                                                 @RequestBody @Valid SaveCategory saveCategory){
        Category category = categoryService.updateOneById(categoryId, saveCategory);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{categoryId}/disable")
    public ResponseEntity<Category> disableOneById(@PathVariable Long categoryId){
        Category category = categoryService.disableOneById(categoryId);
        return ResponseEntity.ok(category);
    }

}
