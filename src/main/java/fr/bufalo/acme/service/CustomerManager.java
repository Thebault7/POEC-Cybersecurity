package fr.bufalo.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
