package dao;

import db.Produs;
import javax.persistence.EntityManager;

public class ProdusDao {
 
    private EntityManager em;
    
    public ProdusDao(EntityManager em){
        this.em = em;
    }
    
    public void addProdus(Produs produs){
        em.persist(produs);
    }
    
    /*
     * operatia find are 2 param tipul obiectului pe care il returnam, 
     *  iar al doilea este valoarea cheii primare.
     * Ca functionalitate: daca id-ul respectiv exista in db
     *   il va lua il pune in context si returneaza produsul existent.
     * Daca id-ul respectiv nu exista ne va intoarce null, iar daca
     *   clasa produs nu este entitate ne va arunca un IllegalArgumentException
    */
    public Produs getProdus(int id){
        return em.find(Produs.class, id);
    }
      
    public void deleteProdus(Produs produs){
        em.remove(produs);
    }
    
    /*
     * Primeste ca param o instanta de entitate si pue in context
     *  si poate fi ulterior folosita ptr operatia de remove
     */
    public Produs mergeProdus(Produs produs){
        return em.merge(produs);
    }
    
    /*
     * Ptr o entitate, actualizeaza cu ce se afla curent in db
    */
    public void refresh(Produs produs){
        em.refresh(em);
    }
    
    /*
     * Reprezinta detasarea tuturor instantelor din context, odata ce facem
     * clear, toate instantele care existau in context se vor sterge din context 
    */
    public void clearContext( ){
        em.clear();
    }
    
    /*
     * Inchiderea manager-ului (managerul este ca o resursa, 
     *  nu impl autoClosable)
    */
    public void closeContext(){
        em.close();
    }
}