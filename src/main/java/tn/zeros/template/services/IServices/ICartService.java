package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Cart;

import java.util.List;

public interface ICartService {
    Cart addCart(Cart cart);

    void removeCart(Long id);

    List<Cart> retrieveAllCarts();

    Cart retrieveCart(Long id);

    Cart modifyCart(Cart cart);

    Cart retrieveCartByUserId(Long userId);

    void clearCart(Long userId);
}
