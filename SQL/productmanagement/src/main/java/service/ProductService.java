package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    int findIndexById(int id);
    Product findById(int id);

   List <Product> findByName(String name); //tìm theo tên sẽ có nhiều đối tượng và có thể trùng nhau nên phải trong List

    void update(int id, Product product);

    void delete(int id);

}
