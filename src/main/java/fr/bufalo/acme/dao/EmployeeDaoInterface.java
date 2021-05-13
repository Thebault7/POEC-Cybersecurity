package fr.bufalo.acme.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Employee;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Component
@Repository(value="employeeDaoInterface")
public interface EmployeeDaoInterface extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByEmail(String email);
}
