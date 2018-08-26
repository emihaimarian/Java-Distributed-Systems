package main;

import db.Catalog;
import db.Student;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c5e6PU");
        EntityManager em = emf.createEntityManager();
        
        Student student1 = new Student();
        student1.setNume("Mihai");
        
        Student student2 = new Student();
        student2.setNume("Gigel");
        
        Catalog catalog = new Catalog();
        Map<Student, Integer> medii = new HashMap<>();
        medii.put(student1, 9);
        medii.put(student2, 7);
        
        catalog.setMedii(medii);
        
        em.getTransaction().begin();
        em.persist(student1);
        em.persist(student2);
        em.persist(catalog);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }    
}