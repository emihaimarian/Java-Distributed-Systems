package db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocParcare {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numar;

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "LocParcare{" + "numar=" + numar + '}';
    }
    
}