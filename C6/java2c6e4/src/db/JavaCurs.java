package db;

import javax.persistence.Entity;

@Entity
public class JavaCurs extends Curs{

    private int durata;

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}