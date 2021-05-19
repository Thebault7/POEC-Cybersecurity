package fr.bufalo.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.dao.CityDaoInterface;

/**
 * @date Created 18/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Service(value = "cityManager")
public class CityManager {

	@Autowired
	private CityDaoInterface cdi;
}
