package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.Category;
import fr.bufalo.acme.repository.CategoryRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date Created 26/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Service
public class CategoryManager {

    @Autowired
    private CategoryRepositoryInterface cr;

    public Category findById(int id) {
        return cr.findById(id).get();
    }

    public List<Category> findAll() {
        return cr.findAll();
    }
}
