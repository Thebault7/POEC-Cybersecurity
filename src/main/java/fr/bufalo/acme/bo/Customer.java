package fr.bufalo.acme.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Data
@Entity
@Table(name="customer")
public class Customer implements Serializable {

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
	
	@Column(name = "address_line_1", length = 100)
	private String addressLine1;
	
	@Column(name = "address_line_2", length = 100)
	private String addressLine2;
	
	@Column(name = "address_line_3", length = 100)
	private String addressLine3;
	
	@Column(name = "phone_number", length = 15)
	private String phoneNumber;
	
	@Column(name = "password", length = 128)
	private String password;
	
	@Column(name = "password_salt", length = 10)
	private String passwordSalt;
	
	@Column(name = "reference", length = 12)
	private String reference;
	
//	@Column(name = "is_active")
//	private boolean isActive;
//	
//	@Column(name = "birthdate")
//	private LocalDate birthdate;
//	
//	@Column(name = "postal_code")
//	private PostalCode postalCode;
	
	@ManyToMany
	@JoinTable(name = "customer_has_employee",
		joinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_employee", referencedColumnName = "id"))
	private List<Employee> listEmployee;
	
	
	public Customer() {
		super();
	}
}
