package fr.bufalo.acme.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @date Created 22/05/2021
 * @author Benjamin LAMBERT / Linh Chi NGUYEN
 * @version v1.0
 *
 */

@Data
@Entity
@Table(name = "sold_product")

public class SoldProduct implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "vat")
    private float vat;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    public SoldProduct() {
    }

    public SoldProduct(int id, int quantity, float price, float vat, Order order, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.vat = vat;
        this.order = order;
        this.product = product;
    }

    public float getTotalExclTaxes() {
        return getPrice() * getQuantity();
    }

    public float getTotalInclTaxes() {
        return getPrice() * (1 + getVat()) * getQuantity();
    }

    @Override
    public String toString() {
        return "SoldProduct{" +
                "id=" + id +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                ", vat=" + vat +
//                ", order=" + order +
//                ", product=" + product +
                '}';
    }
}
