package fr.bufalo.acme.service;

import fr.bufalo.acme.bo.Status;
import fr.bufalo.acme.repository.StatusRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created 26/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Service
public class StatusManager {

    @Autowired
    private StatusRepositoryInterface sr;

    public Status findById(int id) {
        return sr.findById(id).get();
    }

    public List<Status> findAll() {
        return sr.findAll();
    }
}
