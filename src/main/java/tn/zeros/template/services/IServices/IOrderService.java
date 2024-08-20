package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Cart;
import tn.zeros.template.entities.Order;
import tn.zeros.template.entities.User;

import java.util.List;

public interface IOrderService {
    Order addOrder (Order order);

    public void removeOrder(Long id);
    public List<Order> retrieveAllOrders();
    public Order retrieveOrder(Long id);

    public Order modifyOrder(Order order);
    Order createOrderFromCart(User user, Cart cart);

}
