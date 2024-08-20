package tn.zeros.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zeros.template.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
