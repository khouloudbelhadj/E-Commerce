package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Cart;
import tn.zeros.template.entities.User;
import tn.zeros.template.repositories.CartRepository;
import tn.zeros.template.services.IServices.ICartService;
import tn.zeros.template.services.IServices.IUserService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CartService implements ICartService {
    private final CartRepository cartRepository;
    private final IUserService userService;

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void removeCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> retrieveAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart retrieveCart(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart modifyCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart retrieveCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElseGet(() -> {
            User user = userService.retrieveUser(userId);
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });
    }
    @Override
    public void clearCart(Long userId) {
        Cart cart = retrieveCartByUserId(userId);
        if (cart != null) {
            cart.getOrderLines().clear();
            modifyCart(cart);
        }
    }

}
