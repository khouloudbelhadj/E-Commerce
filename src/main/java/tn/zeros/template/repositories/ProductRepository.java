package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zeros.template.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
}