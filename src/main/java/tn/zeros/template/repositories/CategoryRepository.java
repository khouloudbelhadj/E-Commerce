package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.zeros.template.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
