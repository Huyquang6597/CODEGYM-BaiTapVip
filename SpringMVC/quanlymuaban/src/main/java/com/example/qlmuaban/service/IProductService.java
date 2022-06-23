package com.example.qlmuaban.service;

import com.example.qlmuaban.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product>{
    Page<Product> findAllByQuantity(Pageable pageable);
}
