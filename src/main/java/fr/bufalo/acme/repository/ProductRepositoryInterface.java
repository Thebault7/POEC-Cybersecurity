package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created 25/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Repository(value = "productRepositoryInterface")
public interface ProductRepositoryInterface extends JpaRepository<Product, Integer> {
}
