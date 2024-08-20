package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zeros.template.entities.OrderLine;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{
}
