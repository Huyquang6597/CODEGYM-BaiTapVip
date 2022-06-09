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
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product ");) {
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


                products.add(new Product(id, name, price, quantity, description, color, category));
            }
        } catch (SQLException e) {

        }
        return products;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id,productName,price,quantity,categoryId,description,color)values (?,?,?,?,?,?,?)");) {
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setString(7, product.getColor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
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

                product = (new Product(id, productName, price, quantity, description, color, category));
            }
        } catch (SQLException e) {

        }
        return product;
    }

    @Override
    public boolean update(Product product) throws SQLException {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("update product set productName = ?, price = ?, quantity = ?, categoryId = ?, description = ?, color = ? where id = ?");) {

                preparedStatement.setString(1, product.getName());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setInt(3, product.getQuantity());
                preparedStatement.setInt(4, product.getCategory().getId());
                preparedStatement.setString(5, product.getDescription());
                preparedStatement.setString(6, product.getColor());
                preparedStatement.setInt(7,product.getId());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
            return false;
        }


    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from Product where id =  ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findAllOrderByAge() {
        return null;
    }

    @Override
    public List<Product> findAllByCategory(int categoryId) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where categoryId = ?");) {
            preparedStatement.setInt(1, categoryId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("productName");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int categoriesId = rs.getInt("categoryId");
                String description = rs.getString("description");
                String color = rs.getString("color");
                Category category = categoryService.findById(categoriesId);

                productList.add(new Product(id,name, price, quantity,description,color,category));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }

    @Override
    public List<Product> findAllByNameContains(String findName) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where productName like ?");) {
            preparedStatement.setString(1, "%" + findName + "%");
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

                productList.add(new Product(id, name, price, quantity, description, color, category));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
        }

    @Override
    public List<Product> findAllByPrice(double start , double end) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where price between ? and ?");) {
            preparedStatement.setDouble(1, start);
            preparedStatement.setDouble(2, end);
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

                productList.add(new Product(id, name, price, quantity, description, color, category));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;

    }
}
