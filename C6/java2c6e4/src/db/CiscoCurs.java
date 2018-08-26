package db;

import javax.persistence.Entity;

@Entity
public class CiscoCurs extends Curs {
    
    private int nrEchipamente;

    public int getNrEchipamente() {
        return nrEchipamente;
    }

    public void setNrEchipamente(int nrEchipamente) {
        this.nrEchipamente = nrEchipamente;
    }
}