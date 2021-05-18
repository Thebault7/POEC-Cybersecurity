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

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<City> getListCities() {
		return listCities;
	}

	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}

	public List<Customer> getListCustomers() {
		return listCustomers;
	}

	public void setListCustomers(List<Customer> listCustomers) {
		this.listCustomers = listCustomers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
