package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zeros.template.entities.Cart;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
