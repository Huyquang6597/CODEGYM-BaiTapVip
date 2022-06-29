package com.example.qlmuaban.service;

import com.example.qlmuaban.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IGeneralService<Product>{
    Page<Product> findAllByQuantityGreaterThan300(Pageable pageable);

    List<Product> findAllByNameContaining(String name);

}
