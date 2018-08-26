package db;

import javax.persistence.Entity;

@Entity
public class Avocat extends Angajat {
    
    private String specializare;

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
}