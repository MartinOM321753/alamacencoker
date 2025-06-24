package utez.edu.mx.unidad3.models.cede;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.unidad3.models.warehause.Warehause;

import java.util.List;

/*
 * Crear los atributos propios de la entidad
 * Crear los atributos de relacion
 * crear constructores
 * crear getters y setters
 *
 *   */
@Entity
@Table(name = "cede")
public class Cede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "clave")
    private String clave;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;


    @OneToMany(mappedBy = "cede")
    @JsonIgnore
    private List<Warehause>  warehauses;

    public Cede() {
    }

    public Cede(Long id, String clave, String state, String city, List<Warehause> warehauses) {
        this.id = id;
        this.clave = clave;
        this.state = state;
        this.city = city;
        this.warehauses = warehauses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Warehause> getWarehauses() {
        return warehauses;
    }

    public void setWarehauses(List<Warehause> warehauses) {
        this.warehauses = warehauses;
    }
}
