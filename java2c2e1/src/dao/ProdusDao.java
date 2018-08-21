package dao;

import db.Produs;
import javax.persistence.EntityManager;

public class ProdusDao {

    private EntityManager em;
    
    public ProdusDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaProdus(Produs produs){
        /*
         * persist este comportamentul entityManager-ului care adauga in context o instanta noua
         * daca instanta este deja in context o va ignora
         * daca instanta data nu este entitate va arunca un IllegalArgumentException
         * IllegalArgumentException este exceptia pe care o arunca in cazul
         *  in care ii dam o instanta pe care o considera el ca nu are rost sa o stocheze
         * persit-ul nu face altceva decat sa puna in contextul de JPA instanta, ea se va duce in db la un moment dat
         * persis-ul nu corespunde intotdeauna cu stocarea in db
         * cand lucram cu JPA-ul nu trebuie sa ne gandim la db ptr ca o operatie nu inseamna neaparat implicit o operatie cu db direct,
         * persist-ul va rezulta intr-un insert in db dar el pana la urma este vazut doar ca o adaugare a entitatii in context 
         * inserarea in db se poate intampla dupa ce s-a facut operatia asta
         */
        em.persist(produs);
    }
}