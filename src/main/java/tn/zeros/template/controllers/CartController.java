package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Cart;
import tn.zeros.template.services.IServices.ICartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CartController {
    private final ICartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Cart cart) {
        return ResponseEntity.ok().body(cartService.addCart(cart));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cartService.removeCart(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Cart cart) {
        return ResponseEntity.ok().body(cartService.modifyCart(cart));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(cartService.retrieveAllCarts());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(cartService.retrieveCart(id));
    }

    @GetMapping("/getByUser/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.retrieveCartByUserId(userId);
        return ResponseEntity.ok().body(cart);
    }
    @PostMapping("/clear")
    public ResponseEntity<?> clearCart(@RequestBody Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok().body(true);
    }

}
