package utez.edu.mx.unidad3.models.warehause;


import jakarta.persistence.*;
import utez.edu.mx.unidad3.models.cede.Cede;
import utez.edu.mx.unidad3.models.client.Client;

@Entity
@Table(name = "warehouse")
public class Warehause {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String clave;
    @Column(name = "status")
    private String status;
    @Column(name = "sell_price")
    private String sellPrice;
    @Column(name = "rent_price")
    private String rentPrice;

    @ManyToOne
    @JoinColumn(name = "id_cede" , nullable = false)
    private Cede cede;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Warehause() {
    }

    public Warehause(Long id, String clave, String status, String sellPrice, String rentPrice, Cede cede, Client client) {
        this.id = id;
        this.clave = clave;
        this.status = status;
        this.sellPrice = sellPrice;
        this.rentPrice = rentPrice;
        this.cede = cede;
        this.client = client;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Cede getCede() {
        return cede;
    }

    public void setCede(Cede cede) {
        this.cede = cede;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
