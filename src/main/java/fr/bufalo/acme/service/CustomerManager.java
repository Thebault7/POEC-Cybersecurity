package fr.bufalo.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.dao.CustomerDaoInterface;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Service(value = "customerManager")
public class CustomerManager {

	@Autowired
	private CustomerDaoInterface cdi;
	
	public Customer findById(int id) {
		return cdi.findById(id).get();
	}
	
	public List<Customer> findAllByEmployeeId(int id) {
		return null;
	}
}
