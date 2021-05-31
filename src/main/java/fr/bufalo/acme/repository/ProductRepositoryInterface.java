package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Product;

import java.util.List;

import fr.bufalo.acme.bo.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @date Created 25/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Repository(value = "productRepositoryInterface")
public interface ProductRepositoryInterface extends JpaRepository<Product, Integer> {
	
	@Query("SELECT MAX(p.id) FROM Product p")
	Integer findHighestIdValue();

	@Query("SELECT p.reference FROM Product p")
	List<String> findAllReference();

	List<Product> findByStatusNot(Status status);
}
