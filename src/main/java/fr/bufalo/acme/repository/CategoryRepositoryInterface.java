package fr.bufalo.acme.repository;

import fr.bufalo.acme.bo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @date Created 26/05/2021
 * @author Linh Chi Nguyen
 * @version v1.0
 *
 */

@Repository(value = "categoryRepositoryInterface")
public interface CategoryRepositoryInterface extends JpaRepository<Category, Integer> {
}
