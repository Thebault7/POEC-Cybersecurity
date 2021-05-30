package fr.bufalo.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.repository.EmployeeRepositoryInterface;

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
	private EmployeeRepositoryInterface eri;
	
	public List<Employee> findAllByReference(String reference) {
		return eri.findAllByReference(reference);
	}
	
	public Employee findOneByReference(String reference) {
		return eri.findOneByReference(reference);
	}

	public Integer findHighestIdValue() {
		return eri.findHighestIdValue();
	}
}
