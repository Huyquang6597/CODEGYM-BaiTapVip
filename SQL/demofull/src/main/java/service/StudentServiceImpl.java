package service;

import model.Lop;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    ClassService classService = new ClassServiceImpl();

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
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from student");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String studentName = rs.getString("studentName");
                int age = rs.getInt("age");
                int classId = rs.getInt("classId");
                Lop clazz =  classService.findById(classId);

                students.add(new Student(studentId, studentName,clazz,age));
            }
        } catch (SQLException e) {

        }
        return students;
    }

    @Override
    public void add(Student student) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("insert into student(studentName,age,classId)values (?,?,?)");) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3,student.getClazz().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public List<Student> findAllOrderByAge() {
        return null;
    }
}
