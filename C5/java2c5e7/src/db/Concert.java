package db;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyTemporal;
import javax.persistence.TemporalType;

@Entity
@Cacheable(true)
public class Concert {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ElementCollection
    @MapKeyTemporal(TemporalType.TIMESTAMP)
    private Map<Date, String> locatii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Date, String> getLocatii() {
        return locatii;
    }

    public void setLocatii(Map<Date, String> locatii) {
        this.locatii = locatii;
    }
}