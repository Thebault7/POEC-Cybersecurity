package fr.bufalo.acme.bo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
@Table(name = "vat")
public class Vat implements Serializable {

    /**
     * value added tax on product
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "percentage", nullable = false, length = 100)
    private float percentage;

    @OneToMany(mappedBy = "vat")
    private List<Product> products;

}
