package service;

import model.Product;

import java.util.List;

public interface ProductService extends GeneralService<Product>{
    List<Product>findAllByCategory(int categoryId);
    List<Product> findAllByNameContains(String name);
}
