package service;

import controller.ProductServlet;
import model.Product;

import java.util.List;

public interface ProductService extends GenrealService<Product> {
    List<Product> findAllByNameContains(String findName);

}
