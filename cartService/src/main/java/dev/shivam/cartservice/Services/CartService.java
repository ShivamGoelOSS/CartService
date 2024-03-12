package dev.shivam.cartservice.Services;

import dev.shivam.cartservice.Models.Cart;

import java.util.Date;
import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getSingleCart(Long id);
    List<Cart> getCartInDateRange(Date startDate, Date endDate);
    Cart getUserCart(Long id);
    Cart addCart(Cart cart);
    Cart putCart(Long id,Cart cart);
    Cart patchCart(Long id,Cart cart);
    Cart deleteCart(Long id);
}
