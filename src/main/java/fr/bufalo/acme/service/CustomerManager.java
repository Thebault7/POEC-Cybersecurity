package fr.bufalo.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.repository.CustomerRepositoryInterface;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Service(value = "customerManager")
public class CustomerManager {

	@Autowired
	private CustomerRepositoryInterface cdi;
	
	public Customer findById(int id) {
		return cdi.findById(id).get();
	}
	
	public Integer findHighestIdValue() {
		return cdi.findHighestIdValue();
	}
	
	public Customer saveNewCustomer(Customer customer) {
		return cdi.save(customer);
	}
}
