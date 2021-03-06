package fr.bufalo.acme.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @date Created 15/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Entity
@Table(name="city")
public class City implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 100)
	private String name;
	
	@Column(name = "country", length = 3)
	private CountryEnum countryEnum;
	
//	@ManyToMany(mappedBy = "listCities", fetch = FetchType.LAZY)
//	private List<PostalCode> listPostalCodes;
	
	public City() {
		super();
	}

	public City(String name, CountryEnum countryEnum, List<PostalCode> listPostalCodes) {
		super();
		this.name = name;
		this.countryEnum = countryEnum;
//		this.listPostalCodes = listPostalCodes;
	}

	public City(int id, String name, CountryEnum countryEnum, List<PostalCode> listPostalCodes) {
		super();
		this.id = id;
		this.name = name;
		this.countryEnum = countryEnum;
//		this.listPostalCodes = listPostalCodes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CountryEnum getCountryEnum() {
		return countryEnum;
	}

	public void setCountryEnum(CountryEnum countryEnum) {
		this.countryEnum = countryEnum;
	}

//	public List<PostalCode> getListPostalCodes() {
//		return listPostalCodes;
//	}
//
//	public void setListPostalCodes(List<PostalCode> listPostalCodes) {
//		this.listPostalCodes = listPostalCodes;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
