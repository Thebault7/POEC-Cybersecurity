package fr.bufalo.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.dao.CustomerDaoImpl;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Service(value = "customerManager")
public class CustomerManager {

	@Autowired
	private CustomerDaoImpl cdi;
	
	public Customer save(Customer customer) {
		return cdi.save(customer);
	}
	
	public List<Customer> findAllByEmployee(int employeeId) {
		//TODO
		Customer cust1 = new Customer();
		cust1.setId(1);
		cust1.setFirstName("Martin");
		cust1.setLastName("Jacques");
		Customer cust2 = new Customer();
		cust2.setId(2);
		cust2.setFirstName("John");
		cust2.setLastName("Doe");
		List<Customer> listCust = new ArrayList<>();
		listCust.add(cust1);
		listCust.add(cust2);
		return listCust;
	}
}
