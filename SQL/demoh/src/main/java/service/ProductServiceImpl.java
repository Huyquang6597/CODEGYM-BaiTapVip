package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    CategoryService categoryService = new CategoryServiceImpl();

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoh?useSSL=false", "root", "12345678");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("productName");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String description = rs.getString("description");
                String color = rs.getString("color");
                Category category = categoryService.findById(categoryId);


                products.add(new Product(id, name,price,quantity,categoryId,description,color,category));
            }
        } catch (SQLException e) {

        }
        return products;
    }

    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Product where id =  ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String description = rs.getString("description");
                String color = rs.getString("color");
                Category category = categoryService.findById(categoryId);

                product = (new Product(id,productName, price, quantity, categoryId,description,color,category));
            }
        } catch (SQLException e) {

        }
        return product;
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
        return null;
    }

    @Override
    public List<Product> findAllOrderByAge() {
        return null;
    }
}
