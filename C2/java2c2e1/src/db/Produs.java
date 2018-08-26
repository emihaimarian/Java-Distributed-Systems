package db;

//import javax.persistence.Access;
//import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Transient;

//@Access
@Entity
//@Access(AccessType.FIELD)
public class Produs {
    
    @Id
    private int id;
    
    //ori folosesti adnotarea @Transient ori cuv cheie transient
    private String nume;
    //private transient String nume;
    
    private double pret;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@Access(AccessType.PROPERTY)
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
    
}