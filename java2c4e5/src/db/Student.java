package db;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nume;
    
    @ManyToMany(mappedBy = "studenti")
    private Collection<Curs> cursuri;

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

    public Collection<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(Collection<Curs> cursuri) {
        this.cursuri = cursuri;
    }
}