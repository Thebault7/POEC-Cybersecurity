package fr.bufalo.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.dao.EmployeeDaoImpl;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Service(value = "employeeManager")
public class EmployeeManager {
	
	@Autowired(required = false)
	private EmployeeDaoImpl edi;
	
	public Employee addEmployee(Employee employee) {
		return edi.save(employee);
	}
	
	public Optional<Employee> findById(Integer id) {
		return edi.findById(id);
	}
}
