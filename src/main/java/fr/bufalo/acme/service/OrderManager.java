package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.Order;
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
    private OrderRepositoryInterface odi;

    public Order findById(int id) {
        return odi.findById(id).get();
    }

    public List<Order> findAllByEmployeeId(int id) {

        return null;
    }
}
