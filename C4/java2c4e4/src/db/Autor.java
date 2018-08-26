package db;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nume;
    
    @ManyToMany
    private Collection<Articol> articole;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Collection<Articol> getArticole() {
        return articole;
    }

    public void setArticole(Collection<Articol> articole) {
        this.articole = articole;
    }
}