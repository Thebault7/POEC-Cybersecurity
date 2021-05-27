package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Vat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created 26/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Repository(value = "vatRepositoryInterface")
public interface VatRepositoryInterface extends JpaRepository<Vat, Integer> {
}
