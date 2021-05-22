package fr.bufalo.acme.utils.nullifylist;

import fr.bufalo.acme.bo.City;
import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.bo.PostalCode;

/**
 * @date Created 21/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public interface NullifyListInterface {

	public Employee nullifyEmployerListWithinEachCustomer(Employee employee);
	
	public Customer nullifyCustomerListWithinEachEmployee(Customer customer);
	
	public City nullifyCityListWithinEachPostalCode(City city);
	
	public PostalCode nullifyPostalCodeListWithinEachCity(PostalCode postalCode);
	
	public Customer nullifyCustomerListWithinEachPostalCode(Customer customer);
	
	public PostalCode nullifyPostalCodeListWithinEachCustomer(PostalCode postalCode);
}
