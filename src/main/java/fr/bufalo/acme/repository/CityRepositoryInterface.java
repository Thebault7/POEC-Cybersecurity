package fr.bufalo.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.City;

/**
 * @date Created 18/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Repository(value = "cityRepositoryInterface")
public interface CityRepositoryInterface extends JpaRepository<City, Integer> {

	public City findOneById(int id);
}
