package tn.zeros.template.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Cart;
import tn.zeros.template.entities.Order;
import tn.zeros.template.entities.OrderLine;
import tn.zeros.template.entities.User;
import tn.zeros.template.repositories.OrderRepository;
import tn.zeros.template.services.IServices.IOrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> retrieveAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order retrieveOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order modifyOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order createOrderFromCart(User user, Cart cart) {
        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setDateOrder(LocalDate.now());
        newOrder.setReference(generateOrderReference());
        newOrder.setOrderLines(cart.getOrderLines());

        return orderRepository.save(newOrder);
    }

    private String generateOrderReference() {
        return "ORD" + UUID.randomUUID().toString();
    }
}
