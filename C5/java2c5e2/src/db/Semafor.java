package db;

import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;

@Entity
public class Semafor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    private Map<Culoare, String> culori;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Culoare, String> getCulori() {
        return culori;
    }

    public void setCulori(Map<Culoare, String> culori) {
        this.culori = culori;
    }
}