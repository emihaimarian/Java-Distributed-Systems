package service;

import dao.StudentDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import model.Student;

public class MainService {

    private Connection connection; 
            
    private MainService(){
        
        try{ 
            String url = "jdbc:mysql://localhost/db_java";
            String user = "root";
            String password = "";
            
            connection = DriverManager.getConnection(url, user, password);
            
        }catch(Exception e){
            e.printStackTrace();   
        }
    }
    
    private static final class SingletonHolder{
        private static final MainService SINGLETON = new MainService();
    }
    
    public static MainService getInstace(){
        return SingletonHolder.SINGLETON;
    }
    
    public List<Student> addAndGetAll(Student student){
        try{
            StudentDao studentDao = new StudentDao(connection);
            studentDao.addStudent(student);
            return studentDao.findAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}