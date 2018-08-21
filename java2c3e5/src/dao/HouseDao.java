
package dao;

import db.House;
import javax.persistence.EntityManager;

public class HouseDao {
    
    private EntityManager em;
    
    public HouseDao(EntityManager em){
        this.em = em;
    }
    
    public void addHouse(House house){
        em.persist(house);
    }
}
