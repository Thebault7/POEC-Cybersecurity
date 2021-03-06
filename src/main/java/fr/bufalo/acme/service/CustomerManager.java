package fr.bufalo.acme.service;

import java.util.List;

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
	private CustomerRepositoryInterface cri;
	
	public Customer findById(int id) {
		return cri.findById(id).get();
	}
	
	public Integer findHighestIdValue() {
		return cri.findHighestIdValue();
	}
	
	public Customer save(Customer customer) {
		return cri.save(customer);
	}

	public List<String> findAllReference() {
		return cri.findAllReference();
	}

    public List<Customer> findAll() {
		return cri.findAll();
    }
}
