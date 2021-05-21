package fr.bufalo.acme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Employee;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Repository(value="employeeDaoInterface")
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Integer> {

	List<Employee> findAllByReference(String reference);
}
