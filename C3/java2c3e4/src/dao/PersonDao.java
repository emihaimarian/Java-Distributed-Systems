package dao;

import db.Person;
import javax.persistence.EntityManager;

public class PersonDao {
    
    private EntityManager em;
    
    public PersonDao(EntityManager em){
        this.em = em;
    }
    
    public void addPerson(Person person){
        em.persist(person);
    }
}