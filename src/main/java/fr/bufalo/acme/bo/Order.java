package fr.bufalo.acme.bo;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

/**
 * @date Created 22/05/2021
 * @author Benjamin LAMBERT / Linh Chi NGUYEN
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

    @Column(name = "reference", nullable = false, unique = true, length = 11)
    private String reference;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "validation_date")
    private LocalDate validationDate;

    @Column(name = "is_validated", nullable = false)
    private Boolean isValidated;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
    private List<SoldProduct> listSoldProduct;

    @Transient
    private int customerId;

    @Transient
    private List<Integer> productsId;

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
                ", customer=" + customer.getReference() +
                ", ListSoldProduct=" + listSoldProduct.toString() +
                '}';
    }
}
