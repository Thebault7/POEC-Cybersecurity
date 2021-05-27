package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date Created 26/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Repository(value = "statusRepositoryInterface")
public interface StatusRepositoryInterface extends JpaRepository<Status, Integer> {
}
