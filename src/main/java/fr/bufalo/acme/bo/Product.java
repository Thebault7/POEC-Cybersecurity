package fr.bufalo.acme.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @date Created 22/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

// TODO ajouter la taille des données + nullable pour chaque attribut
// TODO gérer les contructeurs
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    private String label;

    @Column(name = "reference")
    private String reference;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Column(name = "price")
    private float price;

    @Column(name = "stock")
    private double stock;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_vat")
    private Vat vat;

    @ManyToMany
    @JoinTable(
            name = "product_has_category",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_category", referencedColumnName = "id")
    )
    private List<Category> categories;

    // uncomment when implementing SoldProduct class
    @OneToMany (mappedBy = "product")
    private List<SoldProduct> soldProducts;



}
