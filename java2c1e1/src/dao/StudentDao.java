package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDao {

    private Connection connection;
    
    public StudentDao(Connection connection){
        this.connection = connection;
    }
    
    public void addStudent(Student student) throws SQLException{
        String sql = "INSERT INTO students VALUES(NULL, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.executeUpdate();
        }
    }
    
    public List<Student> findAll() throws SQLException{
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
        }
        return students;
    }
}