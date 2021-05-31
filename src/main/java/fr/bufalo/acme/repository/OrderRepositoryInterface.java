package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @date Created 23/05/2021
 * @author Benjamin LAMBERT
 * @version v1.0
 *
 */
@Repository(value="orderRepositoryInterface")
public interface OrderRepositoryInterface extends JpaRepository<Order, Integer> {

	@Query("SELECT MAX(o.id) FROM Order o")
	public Integer findHighestIdValue();

	@Query("SELECT reference FROM Order o")
	public List<String> findAllReference();
}

