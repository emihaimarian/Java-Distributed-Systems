package db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nume;
    
    @OneToOne
    private LocParcare locParcare;

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

    public LocParcare getLocParcare() {
        return locParcare;
    }

    public void setLocParcare(LocParcare locParcare) {
        this.locParcare = locParcare;
    }

    @Override
    public String toString() {
        return "Angajat{" + "id=" + id + ", nume=" + nume + ", locParcare=" + locParcare + '}';
    }
}