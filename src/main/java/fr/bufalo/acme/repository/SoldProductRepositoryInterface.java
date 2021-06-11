package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.SoldProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created 09/06/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Repository(value = "soldProductRepositoryInterface")
public interface SoldProductRepositoryInterface extends JpaRepository<SoldProduct, Integer> {
}
