package com.ewerton.rod.springcourse.service.impl;

import com.ewerton.rod.springcourse.dto.SaveProduct;
import com.ewerton.rod.springcourse.exception.ObjectNotFoundException;
import com.ewerton.rod.springcourse.persistence.entity.Category;
import com.ewerton.rod.springcourse.persistence.entity.Product;
import com.ewerton.rod.springcourse.persistence.repository.impl.ProductRepository;
import com.ewerton.rod.springcourse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOneById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product createOne(SaveProduct saveProduct) {

        //Creating the Category needed in order to create the product
        Category category = new Category();
        category.setId(saveProduct.getCategoryId());

        Product product = new Product();
        product.setName(saveProduct.getName());
        product.setCategory(category);
        product.setPrice(saveProduct.getPrice());
        product.setStatus(Product.ProductStatus.ENABLED);

        return productRepository.save(product);
    }

    @Override
    public Product updateOneById(Long productId, SaveProduct saveProduct) {

        Product productFromDB = productRepository.findById(productId)
                .orElseThrow( () -> new ObjectNotFoundException("Product not found with id: " + productId));

        //Creating the Category needed in order to create the product
        Category category = new Category();
        category.setId(saveProduct.getCategoryId());

        productFromDB.setName(saveProduct.getName());
        productFromDB.setCategory(category);
        productFromDB.setPrice(saveProduct.getPrice());

        return productRepository.save(productFromDB);
    }

    @Override
    public Product disableOneById(Long productId) {
        Product productFromDB = productRepository.findById(productId)
                .orElseThrow( () -> new ObjectNotFoundException("Product not found with id: " + productId));

        productFromDB.setStatus(Product.ProductStatus.DISABLED);
        return productRepository.save(productFromDB);
    }
}
