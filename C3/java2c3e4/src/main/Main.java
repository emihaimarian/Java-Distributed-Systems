package main;

import dao.PersonDao;
import db.Person;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3e4PU");
        EntityManager em = emf.createEntityManager();
        PersonDao personDao = new PersonDao(em);
        
        Person person = new Person();
        person.setName("Mihai");
        person.setBirthDate(Date.valueOf(LocalDate.of(2005, 11, 4)));
        
        em.getTransaction().begin();
        personDao.addPerson(person);
        em.getTransaction().commit();
   }
}