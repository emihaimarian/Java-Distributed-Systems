package db;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Librarie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String adresa;
    
    @OneToMany(mappedBy = "librarie", fetch = FetchType.EAGER)
    private Collection<Carte> carti ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Collection<Carte> getCarti() {
        return carti;
    }

    public void setCarti(Collection<Carte> carti) {
        this.carti = carti;
    }

    @Override
    public String toString() {
        return "Librarie{" + "id=" + id + ", adresa=" + adresa + ", carti=" + carti + '}';
    }
}