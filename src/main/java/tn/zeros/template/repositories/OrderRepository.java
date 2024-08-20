package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zeros.template.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
