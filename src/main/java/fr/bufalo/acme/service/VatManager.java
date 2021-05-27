package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.Vat;
import fr.bufalo.acme.repository.VatRepositoryInterface;
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
public class VatManager {

    @Autowired
    private VatRepositoryInterface vr;

    public Vat findById(int id) {
        return vr.findById(id).get();
    }

    public List<Vat> findAll() {
        return vr.findAll();
    }
}
