package fr.bufalo.acme.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @date Created 14/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Column(name = "address_line_1", length = 100, nullable = false)
	private String addressLine1;

	@Column(name = "address_line_2", length = 100, nullable = false)
	private String addressLine2;

	@Column(name = "address_line_3", length = 100, nullable = false)
	private String addressLine3;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "phone_number", length = 15)
	private String phoneNumber;

	@Column(name = "password", length = 128)
	private String password;

	@Column(name = "password_salt", length = 10)
	private String passwordSalt;

	@Column(name = "reference", length = 12, nullable = false, unique = true)
	private String reference;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@Column(name = "birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;

	@ManyToOne
	@JoinColumn(name = "id_postal_code")
	private PostalCode postalCode;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Order> listOrders;

	@ManyToMany
	@JoinTable(name = "customer_has_employee", joinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_employee", referencedColumnName = "id"))
	private List<Employee> listEmployee;

	@Column(name = "id_city")
	private int cityId;

	// Attributes hereafter are used to carry data from jsp to controller. Not to be
	// saved in database.
	@Transient
	private int postalCodeId;
	@Transient
	private String cityName; // keep city name in addition to city id to avoid reccurent calls to database
	@Transient
	private String country;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String addressLine1, String addressLine2, String addressLine3,
			String email, String phoneNumber, String password, String passwordSalt, String reference, boolean isActive,
			LocalDate birthdate, PostalCode postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.reference = reference;
		this.isActive = isActive;
		this.birthdate = birthdate;
		this.postalCode = postalCode;
	}

	public Customer(int id, String firstName, String lastName, String addressLine1, String addressLine2,
			String addressLine3, String email, String phoneNumber, String password, String passwordSalt,
			String reference, boolean isActive, LocalDate birthdate, PostalCode postalCode,
			List<Employee> listEmployee) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.reference = reference;
		this.isActive = isActive;
		this.birthdate = birthdate;
		this.postalCode = postalCode;
		this.listEmployee = listEmployee;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}


	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
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

	public List<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Order> listOrders) {
		this.listOrders = listOrders;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getPostalCodeId() {
		return postalCodeId;
	}

	public void setPostalCodeId(int postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", password=" + password + ", passwordSalt=" + passwordSalt
				+ ", reference=" + reference + ", isActive=" + isActive + ", birthdate=" + birthdate + ", postalCode="
				+ postalCode + ", listOrders=" + listOrders + ", cityId=" + cityId + ", postalCodeId=" + postalCodeId
				+ ", cityName=" + cityName + ", country=" + country + "]";
	}
}
