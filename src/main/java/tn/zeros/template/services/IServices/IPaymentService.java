package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Payment;

import java.util.List;

public interface IPaymentService {
    Payment addPayment (Payment payment);

    public void removePayment(Long id);
    public List<Payment> retrieveAllPayments();
    public Payment retrievePayment(Long id);

    public Payment modifyPayment(Payment payment);
}
