package com.example.qlmuaban.service;

import com.example.qlmuaban.model.Product;

public interface IProductService extends IGeneralService<Product>{
    Iterable<Product> findQuantity(int quantity);
}
