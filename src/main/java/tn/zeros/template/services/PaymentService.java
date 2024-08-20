package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Payment;
import tn.zeros.template.repositories.PaymentRepository;
import tn.zeros.template.services.IServices.IPaymentService;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository ;
    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void removePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> retrieveAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment retrievePayment(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public Payment modifyPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
