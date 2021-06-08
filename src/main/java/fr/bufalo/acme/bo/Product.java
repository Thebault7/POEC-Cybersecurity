package fr.bufalo.acme.bo;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import fr.bufalo.acme.constant.ParameterConstant;

/**
 * @date Created 22/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Valid
@Table(name = "product")
public class Product implements Serializable {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//     TODO spring validation
    @Pattern(regexp = "^P-[0-9]{1,9}$", message = "La référence doit être du format \"P-XXX\" avec XXX étant 1 à 9 caractères numériques.")
    @NonNull
    @Column(name = "reference", nullable = false, unique = true, length = 11)
    private String reference;

    @NonNull
    @Column(name = "label", length = 255)
    private String label;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "picture", length = 100)
    private String picture;

    @Column(name = "price", length = 1000000)
    private float price;

    @Column(name = "stock", length = 1000000)
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_vat", nullable = false)
    private Vat vat;

    @ManyToMany
    @JoinTable(
            name = "product_has_category",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_category", referencedColumnName = "id")
    )
    private List<Category> categories;

    @OneToMany (mappedBy = "product")
    private List<SoldProduct> soldProducts;

    @Transient
    private int statusId;

    @Transient
    private int vatId;

    @Transient
    private List<Integer> categoriesId;

    public Product(@NonNull String reference, String label, String description, String picture, float price,
                   Long stock, Status status, Vat vat, List<Category> categories) {
        this.reference = reference;
        this.label = label;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.vat = vat;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status=" + status +
                ", vat=" + vat +
                ", categories=" + categories +
                '}';
    }
}
