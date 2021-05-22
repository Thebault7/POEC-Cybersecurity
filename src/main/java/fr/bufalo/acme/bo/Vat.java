package fr.bufalo.acme.bo;

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
@Entity
@Table(name = "vat")
public class Vat implements Serializable {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "percentage")
    private float percentage;

    @OneToMany(mappedBy = "vat")
    private List<Product> products;

}
