package fr.bufalo.acme.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name", length = 50)
	private String firstName;
	
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "password", length = 128)
	private String password;
	
	@Column(name = "reference", length = 12, nullable = false, unique = true)
	private String reference;
	
	@Column(name = "is_active", nullable = false)
	private boolean isActive;
	
	@Column(name = "password_salt", length = 10)
	private String passwordSalt;
	
	@ManyToMany(mappedBy = "listEmployee", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Customer> listCustomer;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String email, String password, String reference,
			boolean isActive, String passwordSalt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.reference = reference;
		this.isActive = isActive;
		this.passwordSalt = passwordSalt;
	}

	public Employee(int id, String firstName, String lastName, String email, String password, String reference,
			boolean isActive, String passwordSalt, List<Customer> listCustomer) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.reference = reference;
		this.isActive = isActive;
		this.passwordSalt = passwordSalt;
		this.listCustomer = listCustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
