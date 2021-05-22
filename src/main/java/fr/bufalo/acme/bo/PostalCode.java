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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @date Created 15/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */

@Data
@Entity
@Table(name="postal_code")
public class PostalCode implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "number", length = 10)
	private String number;
	
	@ManyToMany
	@JoinTable(name = "postal_code_has_city",
		joinColumns = @JoinColumn(name = "id_city", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_postal_code", referencedColumnName = "id"))
	private List<City> listCities;
	
	@OneToMany(mappedBy = "postalCode")
	private List<Customer> listCustomers;
	
	public PostalCode() {
	}

	public PostalCode(String number, List<City> listCities, List<Customer> listCustomers) {
		super();
		this.number = number;
		this.listCities = listCities;
		this.listCustomers = listCustomers;
	}

	public PostalCode(int id, String number, List<City> listCities, List<Customer> listCustomers) {
		super();
		this.id = id;
		this.number = number;
		this.listCities = listCities;
		this.listCustomers = listCustomers;
	}

	@Override
	public String toString() {
		return "PostalCode [id=" + id + ", number=" + number + ", listCities=" + listCities + ", listCustomers="
				+ listCustomers + "]";
	}
}
