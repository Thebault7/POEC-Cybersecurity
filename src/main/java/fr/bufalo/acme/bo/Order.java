package fr.bufalo.acme.bo;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @date Created 22/05/2021
 * @author Benjamin LAMBERT
 * @version v1.0
 *
 */

@Data
@Entity
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "validation_date")
    private LocalDate validationDate;

    @Column(name = "reference")
    private String reference;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<SoldProduct> ListSoldProduct;

    public Order() {
    }

    public Order(int id, LocalDate creationDate, LocalDate validationDate, String reference, Customer customer, List<SoldProduct> listSoldProduct) {
        this.id = id;
        this.creationDate = creationDate;
        this.validationDate = validationDate;
        this.reference = reference;
        this.customer = customer;
        ListSoldProduct = listSoldProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", validationDate=" + validationDate +
                ", reference='" + reference + '\'' +
                ", customer=" + customer +
                ", ListSoldProduct=" + ListSoldProduct +
                '}';
    }
}
