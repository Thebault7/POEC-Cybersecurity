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
public class NullifyListImpl implements NullifyListInterface {

	@Override
	public Employee nullifyEmployerListWithinEachCustomer(Employee employee) {
		/*
		 * The fact that Employee contains a list of Customers, and each Customer contains 
		 * a list of Employees, and so on... creates StackOverflowError.
		 * 
		 * To prevent this problem, employee lists of each customer are nullified:
		 */
		for (int j = 0; j < employee.getListCustomer().size(); j++) {
			employee.getListCustomer().get(j).setListEmployee(null);
		}
		return employee;
	}

	@Override
	public Customer nullifyCustomerListWithinEachEmployee(Customer customer) {
		/*
		 * The fact that Customer contains a list of Employees, and each Employee contains 
		 * a list of Customers, and so on... creates StackOverflowError.
		 * 
		 * To prevent this problem, customer lists of each employee are nullified:
		 */
		for (int j = 0; j < customer.getListEmployee().size(); j++) {
			customer.getListEmployee().get(j).setListCustomer(null);
		}
		return customer;
	}

	@Override
	public City nullifyCityListWithinEachPostalCode(City city) {
		/*
		 * The fact that City contains a list of PostalCodes, and each PostalCode contains 
		 * a list of Cities, and so on... creates StackOverflowError.
		 * 
		 * To prevent this problem, city lists of each postalCode are nullified:
		 */
		for (int j = 0; j < city.getListPostalCodes().size(); j++) {
			city.getListPostalCodes().get(j).setListCities(null);
		}
		return city;
	}

	@Override
	public PostalCode nullifyPostalCodeListWithinEachCity(PostalCode postalCode) {
		/*
		 * The fact that PostalCode contains a list of Cities, and each City contains 
		 * a list of PostalCodes, and so on... creates StackOverflowError.
		 * 
		 * To prevent this problem, postalCode lists of each city are nullified:
		 */
		for (int j = 0; j < postalCode.getListCities().size(); j++) {
			postalCode.getListCities().get(j).setListPostalCodes(null);
		}
		return postalCode;
	}

	@Override
	public Customer nullifyCustomerListWithinEachPostalCode(Customer customer) {
		customer.getPostalCode().setListCustomers(null);
		return customer;
	}

	@Override
	public PostalCode nullifyPostalCodeListWithinEachCustomer(PostalCode postalCode) {
		for (int j = 0; j < postalCode.getListCustomers().size(); j++) {
			postalCode.getListCustomers().get(j).setPostalCode(null);
		}
		return postalCode;
	}
}
