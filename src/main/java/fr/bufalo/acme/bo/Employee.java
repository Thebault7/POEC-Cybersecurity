package fr.bufalo.acme.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Data
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
	
	@Column(name = "reference", length = 12)
	private String reference;
	
//	@Column(name = "is_active")
//	private boolean isActive;
	
	@Column(name = "password_salt", length = 10)
	private String passwordSalt;
	
	@ManyToMany(mappedBy = "listEmployee")
	private List<Customer> listCustomer;
	
	public Employee() {
		super();
	}

//	public Employee(String firstName, String lastName, String email, String password, String reference,
//			boolean isActive, String passwordSalt) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.reference = reference;
//		this.isActive = isActive;
//		this.passwordSalt = passwordSalt;
//	}

//	public Employee(int id, String firstName, String lastName, String email, String password, String reference,
//			boolean isActive, String passwordSalt, List<Customer> listCustomer) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.reference = reference;
//		this.isActive = isActive;
//		this.passwordSalt = passwordSalt;
//		this.listCustomer = listCustomer;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", password=" + password + ", reference=" + reference + ", isActive=" + isActive + ", passwordSalt="
//				+ passwordSalt + ", listCustomer=" + listCustomer + "]";
//	}
}
