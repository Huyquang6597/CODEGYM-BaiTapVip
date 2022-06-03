package service;

import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductServiceImpl implements ProductService {
//    ProductService productService = new ProductServiceImpl();

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1, "Huy"));
        products.add(new Product(2, "Hoa"));
        products.add(new Product(3, "Bích"));
        products.add(new Product(4, "Mạnh"));

    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
        public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(products.get(i));
            }
        }
        return productList;
    }

    @Override
    public List<Product> findAllOrderByAge() {
        return null;
    }


    @Override
    public List<Product> findAllByNameContains(String findName) {
        return null;
    }
}
