package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created 23/05/2021
 * @author Benjamin LAMBERT
 * @version v1.0
 *
 */
@Repository(value="orderDaoInterface")
public interface OrderRepositoryInterface extends JpaRepository<Order, Integer> {
}

