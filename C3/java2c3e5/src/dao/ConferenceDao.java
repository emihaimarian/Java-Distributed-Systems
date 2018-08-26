package dao;

import db.Conference;
import javax.persistence.EntityManager;

public class ConferenceDao {

    private EntityManager em;
    
    public ConferenceDao(EntityManager em){
        this.em = em;
    }
    
    public void addConference(Conference conference){
        em.persist(conference);
    }
}