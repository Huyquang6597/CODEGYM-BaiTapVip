package service;

import model.Lop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1905?useSSL=false", "root", "12345678");
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
    public List<Lop> findAll() {
        List<Lop> classes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from clazz");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                classes.add(new Lop(id, name));
            }
        } catch (SQLException e) {

        }
        return classes;
    }

    @Override
    public void add(Lop aClass) throws SQLException {

    }

    @Override
    public Lop findById(int id) {
        Lop clazz = new Lop();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from clazz where id =  ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idClass = rs.getInt("id");
                String name = rs.getString("name");
                clazz = new Lop(idClass, name);
            }
        } catch (SQLException e) {

        }
        return clazz;
    }

    @Override
    public boolean update(Lop aClass) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Lop> findByName(String name) {
        return null;
    }

    @Override
    public List<Lop> findAllOrderByAge() {
        return null;
    }
}
