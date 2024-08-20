package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Payment;
import tn.zeros.template.services.IServices.IPaymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PaymentController {
    private final IPaymentService paymentService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Payment payment){
        return ResponseEntity.ok().body(paymentService.addPayment(payment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        paymentService.removePayment(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody Payment payment ){
        return ResponseEntity.ok().body(paymentService.modifyPayment(payment));

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(paymentService.retrieveAllPayments());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(paymentService.retrievePayment(id));
    }
}
