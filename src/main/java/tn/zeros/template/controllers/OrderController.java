package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Cart;
import tn.zeros.template.entities.Order;
import tn.zeros.template.entities.User;
import tn.zeros.template.services.IServices.ICartService;
import tn.zeros.template.services.IServices.IOrderService;
import tn.zeros.template.services.IServices.IUserService;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    private final IOrderService orderService;
    private final IUserService userService;
    private final ICartService cartService;

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.retrieveAllOrders();
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/getOne/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.retrieveOrder(id);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.modifyOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.removeOrder(id);
    }

    @PostMapping("/createFromCart")
    public ResponseEntity<Order> createOrderFromCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.loadUserByEmail(email); // Use the correct method name
        Cart cart = cartService.retrieveCart(user.getId());

        if (cart == null || cart.getOrderLines().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Order order = orderService.createOrderFromCart(user, cart);
        return ResponseEntity.ok(order);
    }
}
