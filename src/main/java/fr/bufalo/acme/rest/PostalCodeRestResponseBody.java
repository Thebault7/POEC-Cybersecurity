package fr.bufalo.acme.rest;

import java.util.List;

import fr.bufalo.acme.bo.PostalCode;
import lombok.Data;

@Data
public class PostalCodeRestResponseBody {

	private String message;
    private List<PostalCode> result;
    
    
	public PostalCodeRestResponseBody() {
		super();
	}

	public PostalCodeRestResponseBody(String message, List<PostalCode> result) {
		super();
		this.message = message;
		this.result = result;
	}
}
