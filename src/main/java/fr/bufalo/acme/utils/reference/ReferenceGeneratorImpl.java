package fr.bufalo.acme.utils.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.bufalo.acme.service.CustomerManager;

/**
 * @date Created 25/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
@Component
public class ReferenceGeneratorImpl implements ReferenceGeneratorInterface {
	
	@Autowired
	private CustomerManager cm;
	
	@Override
	public String generateReference(ReferenceType type) {
		int index = 0;
		switch (type.getClassName()) {
		case "Customer":
			index = cm.findHighestIdValue();
			break;
		}
		return type.getLetter() + "-" + index;
	}
}
