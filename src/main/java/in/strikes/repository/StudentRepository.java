package in.strikes.repository;

import in.strikes.models.Student;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "cvm1196";



    public void completeCrud(Student student){
        String query = "INSERT INTO students (name, email, age) VALUES(?,?,?)";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected == 1){
                System.out.println("Creation successfull");
            }else{
                System.out.println("Creation failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(Student student){
        String query = "INSERT INTO students(name,email,age) VALUES(?,?,?)";
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            int result = preparedStatement.executeUpdate();
            if(result==1){
                System.out.println("Created operation successfull");
            }else{
                System.out.println("Creation Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateUser(Student student, Long id){
        String query = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected == 1){
                System.out.println("Updation successfull");
            }else{
                System.out.println("Updation failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(Long id){
        String query = "DELETE FROM students WHERE id = ?";
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setLong(1, id);
            int result = preparedStatement.executeUpdate();
            if(result==1){
                System.out.println("Delete operation successfull");
            }else{
                System.out.println("Delete Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUserById(Long id){
        String query = "SELECT id,name,email,age FROM students WHERE id = ?";
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = mapRow(resultSet);
            System.out.println(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        if (resultSet.next()) {
            student.setId(resultSet.getLong("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setAge(resultSet.getInt("age"));
        }
        return student;
    }
}
