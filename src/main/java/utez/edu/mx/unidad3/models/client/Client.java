package utez.edu.mx.unidad3.models.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.unidad3.models.warehause.Warehause;

import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone", nullable = false)
    private String  phone;
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Warehause> warehauses;

    public Client() {
    }

    public Client(Long id, String name, String phone, String email, List<Warehause> warehauses) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.warehauses = warehauses;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Warehause> getWarehauses() {
        return warehauses;
    }

    public void setWarehauses(List<Warehause> warehauses) {
        this.warehauses = warehauses;
    }
}


