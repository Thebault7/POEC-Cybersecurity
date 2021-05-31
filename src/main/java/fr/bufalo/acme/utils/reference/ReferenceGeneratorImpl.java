package fr.bufalo.acme.utils.reference;

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
	
	@Override
	public String generateReference(ReferenceType type) {
		Integer index = 0;
		switch (type.getClassName()) {
		case CUSTOMER:
			index = cm.findHighestIdValue();
			if (index == null) {
				index = 0;
			}
			index++;
			break;
		case EMPLOYEE:
			index = em.findHighestIdValue();
			if (index == null) {
				index = 0;
			}
			index++;
			break;
		case PRODUCT:
			index = pm.findHighestIdValue();
			if (index == null) {
				index = 0;
			}
			index++;
			break;
		case ORDER:
			index = om.findHighestIdValue();
			if (index == null) {
				index = 0;
			}
			index++;
			break;
		}
		return type.getLetter() + "-" + index;
	}
}
