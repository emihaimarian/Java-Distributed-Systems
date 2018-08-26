package db;

import javax.persistence.Entity;

@Entity
public class Programator extends Angajat {
    
    private String limbajDeProgramare;

    public String getLimbajDeProgramare() {
        return limbajDeProgramare;
    }

    public void setLimbajDeProgramare(String limbajDeProgramare) {
        this.limbajDeProgramare = limbajDeProgramare;
    }
}