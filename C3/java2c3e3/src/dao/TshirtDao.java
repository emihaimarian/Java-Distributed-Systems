package dao;

import db.Tshirt;
import javax.persistence.EntityManager;

public class TshirtDao {
 
    private EntityManager em;
    
    public TshirtDao(EntityManager em){
        this.em = em;
    }
    
    public void add(Tshirt tshirt){
        em.persist(tshirt);
    }
}