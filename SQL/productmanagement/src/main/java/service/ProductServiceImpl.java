package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1, "IP", 30000));
        products.add(new Product(2, "SS", 40000));
        products.add(new Product(3, "XM", 50000));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public int findIndexById(int id) {
       int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id){
                index = i;
            }
        }
        return index;
    }


    @Override
    public Product findById(int id) {
        for (Product product  : products ) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
       int indexOf = findIndexById(id);
       products.set(indexOf,product);
    }

    @Override
    public void delete(int id) {
    if(findIndexById(id) != -1)
        products.remove(findIndexById(id));
    }
}
