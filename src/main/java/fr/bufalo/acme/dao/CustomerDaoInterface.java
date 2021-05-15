package fr.bufalo.acme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Customer;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Repository(value="customerDaoInterface")
public interface CustomerDaoInterface extends JpaRepository<Customer, Integer> {

	
}
