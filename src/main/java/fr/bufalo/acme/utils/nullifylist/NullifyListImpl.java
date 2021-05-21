package fr.bufalo.acme.utils.nullifylist;

import fr.bufalo.acme.bo.Employee;

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
		 * a list of Employee, and so on... creates StackOverFlowError.
		 * 
		 * To prevent this problem, employee lists of each customer are nullified:
		 */
		for (int j = 0; j < employee.getListCustomer().size(); j++) {
			employee.getListCustomer().get(j).setListEmployee(null);
		}
		return employee;
	}
}
