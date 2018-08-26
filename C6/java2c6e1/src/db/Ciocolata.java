package db;

import javax.persistence.Entity;

@Entity
public class Ciocolata extends Produs {
    
    private int kCal;   

    public int getkCal() {
        return kCal;
    }

    public void setkCal(int kCal) {
        this.kCal = kCal;
    }
}