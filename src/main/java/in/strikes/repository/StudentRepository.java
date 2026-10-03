package in.strikes.repository;

import in.strikes.models.Student;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "cvm1196";

    Connection connection = null;
    PreparedStatement preparedStatement;

    public void createUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO students(name,email,age) " +
                    "VALUES('Shivam Raj','rajshivam1912@gamil.com',24)";
            int result = statement.executeUpdate(query);

            if(result==1){
                System.out.println("Created operation successfull");
            }else{
                System.out.println("Creation Failed");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "UPDATE students SET age = 26 " +
                    "WHERE id = 1";
            int result = statement.executeUpdate(query);

            if(result==1){
                System.out.println("Update operation successfull");
            }else{
                System.out.println("Update Failed");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM students where id = 1";
            int result = statement.executeUpdate(query);

            if(result==1){
                System.out.println("Created operation successfull");
            }else{
                System.out.println("Creation Failed");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  void getUserById(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT id,name,email,age from students WHERE id = 2";
            ResultSet resultSet = statement.executeQuery(query);
            Student student = mapRow(resultSet);
            System.out.println(student);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void completeCrud(Student student){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = """
                           INSERT INTO (name, email, age) 
                               VALUES(?,?,?)
                               """;

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            int rowafftectd = preparedStatement.executeUpdate();

            if(rowafftectd==1){
                System.out.println("Creation successfull");
            }else{
                System.out.println("cretion failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            try{
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                connection.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
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
