package fr.bufalo.acme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Employee;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Repository(value="employeeRepositoryInterface")
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByReference(String reference);
	public Employee findOneByReference(String reference);
	
	@Query("SELECT reference FROM Employee e")
	public List<String> findAllReference();
	
	@Query("SELECT MAX(e.id) FROM Employee e")
	public Integer findHighestIdValue();
	
}
