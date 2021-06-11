package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.SoldProduct;
import fr.bufalo.acme.repository.SoldProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date Created 09/06/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Service
public class SoldProductManager {

    @Autowired
    private SoldProductRepositoryInterface spr;

    public SoldProduct findById(int id){
        return spr.findById(id).get();
    }

    public List<SoldProduct> findAll(){
        return spr.findAll();
    }

    public SoldProduct save(SoldProduct soldProduct){
        spr.save(soldProduct);
        return soldProduct;
    }
}
