package db;

import javax.persistence.Embeddable;

@Embeddable
public class License {
    
    private String reginue;
    private int nr;
    private String cod;

    public String getReginue() {
        return reginue;
    }

    public void setReginue(String reginue) {
        this.reginue = reginue;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}