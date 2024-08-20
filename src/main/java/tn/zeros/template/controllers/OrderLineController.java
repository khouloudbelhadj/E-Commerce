package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.OrderLine;
import tn.zeros.template.services.IServices.IOrderLineService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderLine")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OrderLineController {
    private final IOrderLineService orderLineService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody OrderLine orderLine){
        return ResponseEntity.ok().body(orderLineService.addOrderLine(orderLine));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        orderLineService.removeOrderLine(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody OrderLine orderLine ){
        return ResponseEntity.ok().body(orderLineService.modifyOrderLine(orderLine));

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(orderLineService.retrieveAllOrderLines());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(orderLineService.retrieveOrderLine(id));
    }
}
