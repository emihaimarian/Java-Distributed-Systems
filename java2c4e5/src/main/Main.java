package main;

import db.Curs;
import db.Student;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4e5PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Student student = new Student();
            student.setNume("Student 1");
            
            Curs curs = new Curs();
            curs.setNume("Curs 1");
            
            student.setCursuri(new ArrayList<>());
            curs.setStudenti(new ArrayList<>());
            
            student.getCursuri().add(curs);
            curs.getStudenti().add(student);
            
            em.getTransaction().begin();
            em.persist(student);
            em.persist(curs);
            em.getTransaction().commit();
            
        }finally{
            em.close();
            emf.close();
        }
        
       
    }    
}