package db;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Curs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nume;
    
    @ManyToMany
    @JoinTable(
            name = "tabela_de_legatura",
            joinColumns = @JoinColumn(name = "joinColumnA"),
            inverseJoinColumns = @JoinColumn(name = "joinColumnB")
    )
    private Collection<Student> studenti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Collection<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Collection<Student> studenti) {
        this.studenti = studenti;
    }
}