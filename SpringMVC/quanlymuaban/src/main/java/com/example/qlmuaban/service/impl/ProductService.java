package com.example.qlmuaban.service.impl;

import com.example.qlmuaban.model.Product;
import com.example.qlmuaban.repository.IProductRepository;
import com.example.qlmuaban.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByQuantityGreaterThan300(Pageable pageable) {
        return productRepository.findAllByQuantityGreaterThan300(pageable);
    }

    @Override
    public List<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }
}