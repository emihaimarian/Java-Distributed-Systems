package main;

import dao.ConferenceDao;
import dao.HouseDao;
import db.Address;
import db.Conference;
import db.House;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
 
    public static void main (String [] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3e5PU");
        EntityManager em = emf.createEntityManager();
        
        HouseDao houseDao = new HouseDao(em);
        ConferenceDao conferenceDao = new ConferenceDao(em);
        
        Address address = new Address();
        address.setCity("Bucharest");
        address.setStreet("Bd. Unirii");
        address.setNumber(10);
        
        Conference conference = new Conference();
        conference.setName("Conference 1");
        conference.setStreet(address);
        
        House house = new House();
        house.setStreet(address);
        
        
        em.getTransaction().begin();
        houseDao.addHouse(house);
        conferenceDao.addConference(conference);
        em.getTransaction().commit();
    }
}