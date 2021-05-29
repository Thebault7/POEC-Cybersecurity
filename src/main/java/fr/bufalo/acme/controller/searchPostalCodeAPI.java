package fr.bufalo.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.bufalo.acme.bo.PostalCode;
import fr.bufalo.acme.rest.PostalCodeRestResponseBody;
import fr.bufalo.acme.service.PostalCodeManager;

/**
 * This controller is used to access the postal_code table in database,
 * and retrieve postal codes, from the client side using a REST API.
 * 
 * @date Created 29/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
@RestController
public class searchPostalCodeAPI {

	@Autowired
	private PostalCodeManager pcm;
	
	private static final String SEARCH_POSTAL_CODE = "searchPostalCodes";
	private static final String NUMBER = "number";
	private static final String NOTHING_FOUND_MESSAGE = "No postal code find matching this number";
	private static final String SUCCESS = "success";
	
	@RequestMapping(method = RequestMethod.GET, path = {"/" + SEARCH_POSTAL_CODE + "/{" + NUMBER + "}"})
	public ResponseEntity<?> searchPostalCodesAPI(@PathVariable(value=NUMBER) String number) {
		System.out.println("------------------->  " + number);
		
		List<PostalCode> listPostalCodes = pcm.findAllByNumberLike(number);
		
		PostalCodeRestResponseBody result = new PostalCodeRestResponseBody();
		if (listPostalCodes.isEmpty()) {
			result.setMessage(NOTHING_FOUND_MESSAGE);
		} else {
			result.setMessage(SUCCESS);
			result.setResult(listPostalCodes);
		}
		
		return ResponseEntity.ok(result);
	}
}
