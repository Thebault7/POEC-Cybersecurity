package fr.bufalo.acme.bo;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @date Created 22/05/2021
 * @author Benjamin LAMBERT
 * @version v1.0
 *
 */

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

    @OneToMany(mappedBy = "order", cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
    private List<SoldProduct> listSoldProduct;

    public Order() {
    }

    public Order(int id, LocalDate creationDate, LocalDate validationDate, String reference, Customer customer, List<SoldProduct> listSoldProduct) {
        this.id = id;
        this.creationDate = creationDate;
        this.validationDate = validationDate;
        this.reference = reference;
        this.customer = customer;
        this.listSoldProduct = listSoldProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", validationDate=" + validationDate +
                ", reference='" + reference + '\'' +
                ", customer=" + customer +
                ", ListSoldProduct=" + listSoldProduct +
                '}';
    }
}
