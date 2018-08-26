package db;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transmisie {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    private String mesaj;
    
    private TipTransmisie tipTransmisie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public TipTransmisie getTipTransmisie() {
        return tipTransmisie;
    }

    public void setTipTransmisie(TipTransmisie tipTransmisie) {
        this.tipTransmisie = tipTransmisie;
    }
}