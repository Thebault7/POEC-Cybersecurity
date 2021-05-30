package fr.bufalo.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.City;
import fr.bufalo.acme.repository.CityRepositoryInterface;

/**
 * @date Created 18/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Service(value = "cityManager")
public class CityManager {

	@Autowired
	private CityRepositoryInterface cri;
	
	public City findOneById(int id) {
		return cri.findOneById(id);
	}
}
