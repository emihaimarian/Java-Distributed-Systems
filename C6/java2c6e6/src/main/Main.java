package main;

import db.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e6PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Student student = new Student();
            student.setVarsta(20);
            student.setNume("Popescu");
            student.setPrenume("Popa");
           
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        
        } finally{
            em.close();
            emf.close();
        }
    }    
}