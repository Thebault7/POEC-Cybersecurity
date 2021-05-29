package fr.bufalo.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Customer;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Repository(value="customerDaoInterface")
public interface CustomerRepositoryInterface extends JpaRepository<Customer, Integer> {

	@Query("SELECT MAX(c.id) FROM Customer c")
	public Integer findHighestIdValue();
	
}
