package fr.bufalo.acme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Employee;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Repository(value="EmployeeDao")
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
