package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.Order;
import fr.bufalo.acme.bo.Product;
import fr.bufalo.acme.repository.OrderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date Created 23/05/2021
 * @author Benjamin LAMBERT
 * @version v1.0
 *
 */
@Service(value = "orderManager")
public class OrderManager {

    @Autowired
    private OrderRepositoryInterface ori;

    public Order findById(int id) {
        return ori.findById(id).get();
    }

    public List<Order> findAllByEmployeeId(int id) {
        return null;
    }

    public Order save(Order order){
        ori.save(order);
        return order;
    }
    
    public Integer findHighestIdValue() {
		return ori.findHighestIdValue();
	}

	public List<String> findAllReference() {
		return ori.findAllReference();
	}
}
