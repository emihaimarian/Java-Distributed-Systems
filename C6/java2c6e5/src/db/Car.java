package db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Car {
    
    @EmbeddedId
    private License license;
    
    private String carType;

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
