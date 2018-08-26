package main;

import db.Car;
import db.License;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c6e5PU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Car car = new Car();
            car.setCarType("BMW");
            
            License license = new License();
            license.setReginue("B");
            license.setNr(123);
            license.setCod("EUR");
            
            car.setLicense(license);
            
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
       } finally{
            em.close();
            emf.close();
        }
    }
}