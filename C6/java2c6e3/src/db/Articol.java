package db;

import javax.persistence.Entity;

@Entity
public class Articol extends Publicatie {
    
    private String revista;

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }
}