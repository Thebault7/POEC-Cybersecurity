package fr.bufalo.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.dao.CountryDaoInterface;

@Service(value = "countryManager")
public class CountryManager {

	@Autowired
	private CountryDaoInterface cdi;
}
