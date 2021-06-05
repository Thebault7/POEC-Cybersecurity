package fr.bufalo.acme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Order;
import fr.bufalo.acme.bo.Product;

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

	@Query("SELECT o.reference FROM Order o")
	public List<String> findAllReference();

	@Query("select distinct o from Order o join o.customer c join c.listEmployee le where le.id = :employeeId")
	public List<Order> findAllOrders(@Param(value = "employeeId") int employeeId);

	@Query("select distinct p from Product p join p.soldProducts sp join sp.order o where o.id = :orderId ")
	public List<Product> findAllProducts(@Param(value = "orderId") int orderId);
}

