package fr.bufalo.acme.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Employee;

/**
 * @date created 13/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Repository(value="employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDaoInterface {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-bufalo");
	private EntityManager em = emf.createEntityManager();
	
	
	
	public EmployeeDaoImpl() {
	}
	
	public Optional<Employee> findByEmail(String email) {
		// TODO 
		return null;
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Persists an employee in the database. If an exception is raised,
	 * a rollback is done, and the returning Employee will have 0 as id.
	 * @param Employee to be persisted
	 * @return Employee persisted
	 */
	@Override
	public <S extends Employee> S save(S entity) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(entity);
			transaction.commit();
			em.close();
			return entity;
		} catch(Exception e) {
			transaction.rollback();
			entity.setId(0);
			return entity;
		}
	}

	/**
	 * @param Integer id of the employee in the database
	 * @return Optional<Employee>
	 */
	@Override
	public Optional<Employee> findById(Integer id) {
		return Optional.of(em.find(Employee.class, id));
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Employee> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Employee> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Employee> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
