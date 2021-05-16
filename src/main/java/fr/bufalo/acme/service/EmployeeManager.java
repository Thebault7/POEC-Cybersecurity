package fr.bufalo.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.dao.EmployeeDaoImpl;
import fr.bufalo.acme.dao.EmployeeDaoInterface;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Component
@Service(value = "employeeManager")
public class EmployeeManager {
	
	@Autowired
	private EmployeeDaoInterface edi;
	
	public Employee addEmployee(Employee employee) {
		return edi.save(employee);
	}
	
	public Optional<Employee> findById(Integer id) {
		return edi.findById(id);
	}
	
	public Optional<Employee> findByEmail(String email) {
		return edi.findByEmail(email);
	}
}
