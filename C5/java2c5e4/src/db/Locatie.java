package db;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ElementCollection
    private Map<String, Adresa> adresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Adresa> getAdresa() {
        return adresa;
    }

    public void setAdresa(Map<String, Adresa> adresa) {
        this.adresa = adresa;
    }
}