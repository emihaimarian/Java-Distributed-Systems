package main;

import annotations.Valoare;
import java.lang.reflect.Field;
import model.Ambalaj;
import model.Produs;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Ambalaj ambalaj = new Ambalaj();
        Produs produs = new Produs();
        
        ambalaj.setProdus(produs);
        
        Class ambalajClass = Class.forName("model.Ambalaj");
        Class produsClass = Class.forName("model.Produs");
        
        Field produsField = ambalajClass.getDeclaredField("produs");
        Valoare valoare = produsField.getAnnotation(Valoare.class);
        produs.setNume(valoare.nume());
        produs.setPret(valoare.pret());
        
        System.out.println(ambalaj.getProdus().getNume());
        System.out.println(ambalaj.getProdus().getPret());
    }
}