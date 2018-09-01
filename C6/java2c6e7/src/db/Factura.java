package db;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "Factura.getAll", query = "SELECT factura FROM Factura factura"),
    @NamedQuery(name = "Factura.getById", query = "SELECT factura FROM Factura factura WHERE factura.id := id")
})
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String serie;
    private int numar;
    
    @OneToMany(mappedBy = "factura")
    private Collection<LinieFactura> linii;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public Collection<LinieFactura> getLinii() {
        return linii;
    }

    public void setLinii(Collection<LinieFactura> linii) {
        this.linii = linii;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", serie=" + serie + ", numar=" + numar + ", linii=" + linii + '}';
    }
}
