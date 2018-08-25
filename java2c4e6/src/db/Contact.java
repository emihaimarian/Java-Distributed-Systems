package db;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ElementCollection
    @CollectionTable(name = "numere_de_telefon")
    private String numeContact;
    
    private List<String> telefoane;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeContact() {
        return numeContact;
    }

    public void setNumeContact(String numeContact) {
        this.numeContact = numeContact;
    }

    public List<String> getTelefoane() {
        return telefoane;
    }

    public void setTelefoane(List<String> telefoane) {
        this.telefoane = telefoane;
    }
}