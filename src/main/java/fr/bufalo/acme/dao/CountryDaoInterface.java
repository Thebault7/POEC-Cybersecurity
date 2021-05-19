package fr.bufalo.acme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.Country;

@Repository(value = "countryDaoInterface")
public interface CountryDaoInterface extends JpaRepository<Country, Integer> {

}
