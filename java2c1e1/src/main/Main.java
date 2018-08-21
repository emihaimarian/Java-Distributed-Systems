package main;

import java.util.List;
import model.Student;
import service.MainService;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alex");
        student.setEmail("alex@gmail.com");
        List<Student> students = MainService.getInstace().addAndGetAll(student);
        students.forEach(System.out::println);
    }    
}