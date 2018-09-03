package dao;

import db.Produs;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProdusDao {

    private EntityManager em;
    
    public ProdusDao(EntityManager em){
        this.em = em;
    }
    
    public void addProdus(Produs produs){
        em.persist(produs);
    }
    
    public List<Produs> getAllProducts(){
        
        List<Produs> produse = new ArrayList<>();
        String sql = "SELECT produs FROM Produs produs";    
        TypedQuery<Produs> typedQuery = em.createQuery(sql, Produs.class);
        
        return typedQuery.getResultList();
    }
    
    public void deleteProduct(Produs produs){
        
        produs = em.merge(produs);
        em.remove(produs);
    }
}
