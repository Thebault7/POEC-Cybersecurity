package fr.bufalo.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bufalo.acme.bo.PostalCode;
import fr.bufalo.acme.repository.PostalCodeRepositoryInterface;

/**
 * @date Created 15/05/2021
 * @author Frederic Thebault
 * @version v1.0
 *
 */
@Service(value = "postalCodeManager")
public class PostalCodeManager {

	@Autowired
	private PostalCodeRepositoryInterface pcdi;
	
	public List<PostalCode> findAllByNumber(String number) {
		return pcdi.findAllByNumber(number);
	}
	
	public List<PostalCode> findAllByNumberLike(String number) {
		return pcdi.findAllByNumberLike("%" + number + "%");
	}
}
