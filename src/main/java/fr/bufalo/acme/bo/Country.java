package fr.bufalo.acme.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="country")
@Cacheable
public class Country implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "country_code", length = 3)
	private String countryCode;
	
	@OneToMany(mappedBy = "country")
	private List<City> listCities;
	
	public Country() {
	}
}
