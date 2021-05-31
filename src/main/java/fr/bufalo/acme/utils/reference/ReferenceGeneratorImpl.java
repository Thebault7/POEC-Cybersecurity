package fr.bufalo.acme.utils.reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.bufalo.acme.service.CustomerManager;
import fr.bufalo.acme.service.EmployeeManager;
import fr.bufalo.acme.service.OrderManager;
import fr.bufalo.acme.service.ProductManager;

/**
 * @date Created 25/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
@Component
public class ReferenceGeneratorImpl implements ReferenceGeneratorInterface {
	
	@Autowired
	private CustomerManager cm;
	@Autowired
	private EmployeeManager em;
	@Autowired
	private ProductManager pm;
	@Autowired
	private OrderManager om;
	
	private static final String CUSTOMER = "Customer";
	private static final String EMPLOYEE = "Employee";
	private static final String PRODUCT = "Product";
	private static final String ORDER = "Order";
	
	private List<String> listReferences = new ArrayList<>();
	private List<Integer> listIndexes = new ArrayList<>();
	private Integer index = 1;
	
	@Override
	public String generateReference(ReferenceType type) {
		
		switch (type.getClassName()) {
		case CUSTOMER:
			listReferences = cm.findAllReference();
			extractHighestreferenceNumber(listReferences);
			break;
		case EMPLOYEE:
			listReferences = em.findAllReference();
			extractHighestreferenceNumber(listReferences);
			break;
		case PRODUCT:
			listReferences = pm.findAllReference();
			extractHighestreferenceNumber(listReferences);
			break;
		case ORDER:
			listReferences = om.findAllReference();
			extractHighestreferenceNumber(listReferences);
			break;
		}
		return type.getLetter() + "-" + index;
	}
	
	private Integer extractHighestreferenceNumber(List<String> listReferences) {
		if (listReferences != null) {
			for (String reference : listReferences) {
				listIndexes.add((Integer.parseInt(reference.split("-")[1])));
			}
			index = Collections.max(listIndexes);
			index++;
		}
		return index;
	}
}
