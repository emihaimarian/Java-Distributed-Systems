package model;

import annotations.Valoare;

public class Ambalaj {
    
    @Valoare(nume = "ciocolata", pret = 5)
    
    private Produs produs;

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
}