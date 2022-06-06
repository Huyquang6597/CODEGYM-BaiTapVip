package service;

import model.Product;

import java.util.List;

public interface ProductService extends GeneralService<Product>{
    List<Product>findAllByCategory(int categoriesId);
    List<Product> findAllByNameContains(String findName);
}
