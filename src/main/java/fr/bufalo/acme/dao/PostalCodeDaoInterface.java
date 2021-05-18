package fr.bufalo.acme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bufalo.acme.bo.PostalCode;

/**
 * @date Created 15/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Repository(value="postalCodeDaoInterface")
public interface PostalCodeDaoInterface extends JpaRepository<PostalCode, Long> {

}
