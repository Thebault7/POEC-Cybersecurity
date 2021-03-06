package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.Product;
import fr.bufalo.acme.bo.Status;
import fr.bufalo.acme.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date Created 25/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Service(value = "productManager")
public class ProductManager {

    @Autowired
    private ProductRepositoryInterface pr;

    public Product findById(int id) {
        return pr.findById(id).get();
    }

    public List<Product> findAll() {
        return pr.findAll();
    }

    public Product save(Product product){
        pr.save(product);
        return product;
    }

    public Integer findHighestIdValue() {
		return pr.findHighestIdValue();
	}

	public List<String> findAllReference() {
		return pr.findAllReference();
	}

    public List<Product> findByStatusNot(Status status) {
        return pr.findByStatusNot(status);
    }
}
