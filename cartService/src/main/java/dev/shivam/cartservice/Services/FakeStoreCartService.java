package dev.shivam.cartservice.Services;

import dev.shivam.cartservice.Models.Cart;
import dev.shivam.cartservice.dtos.FakeStoreCartDto;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FakeStoreCartService implements CartService {
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Cart> getAllCarts() {
        List<Cart> cartList =  restTemplate.getForObject(
                "https://fakestoreapi.com/carts/",
                List.class
        );
        return cartList;
    }
    @Override
    public Cart getSingleCart(Long id) {
        FakeStoreCartDto fakeStoreCartDto =  restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                FakeStoreCartDto.class
        );

        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setProducts(new ArrayList<>());
        cart.getProducts().addAll(fakeStoreCartDto.getProducts());

        return cart;
    }
    @Override
    public List<Cart> getCartInDateRange(Date startDate, Date endDate) {
        List<Cart> cartList =  restTemplate.getForObject(
                "https://fakestoreapi.com/carts/",
                List.class
        );
        List<Cart> carts=new ArrayList<>();
        for(Cart cart:cartList){
            if(cart.getDate().compareTo(startDate)<=0){
                if(cart.getDate().compareTo(endDate)>=0){
                    carts.add(cart);
                }
            }
        }
        return carts;
    }
    @Override
    public Cart getUserCart(Long id) {
        FakeStoreCartDto fakeStoreCartDto =  restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/" + id,
                FakeStoreCartDto.class
        );

        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setProducts(new ArrayList<>());
        cart.getProducts().addAll(fakeStoreCartDto.getProducts());

        return cart;
    }
    @Override
    public Cart addCart(Cart cart) {
        HttpEntity<String> request = new HttpEntity<String>(cart.toString());
        Cart newCart =  restTemplate.postForObject(
                "https://fakestoreapi.com/carts/",
                request, Cart.class
        );
        return newCart;
    }
    @Override
    public Cart putCart(Long id,Cart cart){
        HttpEntity<String> request = new HttpEntity<String>(cart.toString());
        Cart updatedCart =  restTemplate.postForObject(
                "https://fakestoreapi.com/carts/"+id,
                request, Cart.class
        );
        return updatedCart;
    }
    @Override
    public Cart patchCart(Long id,Cart cart){
        HttpEntity<String> request = new HttpEntity<String>(cart.toString());
        Cart newCart =  restTemplate.patchForObject(
                "https://fakestoreapi.com/carts/" + id,
                request, Cart.class
        );
        return newCart;
    }
    @Override
    public Cart deleteCart(Long id){
        FakeStoreCartDto fakeStoreCartDto =  restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" + id,
                FakeStoreCartDto.class
        );

        Cart cart = new Cart();
        cart.setId(fakeStoreCartDto.getId());
        cart.setUserId(fakeStoreCartDto.getUserId());
        cart.setDate(fakeStoreCartDto.getDate());
        cart.setProducts(new ArrayList<>());
        cart.getProducts().addAll(fakeStoreCartDto.getProducts());

        return cart;
    }
}
