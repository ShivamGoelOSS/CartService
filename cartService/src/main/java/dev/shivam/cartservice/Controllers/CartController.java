package dev.shivam.cartservice.Controllers;

import dev.shivam.cartservice.Models.Cart;
import dev.shivam.cartservice.Services.CartService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }
    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id") Long id) {
        return cartService.getSingleCart(id);
    }
    @PostMapping("/carts")
    public List<Cart> getCartInDateRange(@RequestParam("startdate") String startdate,
                                 @RequestParam("enddate") String enddate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startdate);
        Date endDate = simpleDateFormat.parse(enddate);
        return cartService.getCartInDateRange(startDate,endDate);
    }
    @GetMapping("/carts/user/{id}")
    public Cart getUserCart(@PathVariable("id") Long id) {
        return cartService.getUserCart(id);
    }
//    @PostMapping("/carts")
//    public Cart addCart(@RequestBody Cart cart) {
//        return cartService.addCart(cart);
//    }
    @PutMapping("/carts/{id}")
    public Cart putCart(@PathVariable("id") Long id,@RequestBody Cart cart){
        return cartService.putCart(id,cart);
    }
    @PatchMapping("/carts/{id}")
    public Cart patchCart(@PathVariable("id") Long id,@RequestBody Cart cart){
        return cartService.patchCart(id,cart);
    }
    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id") Long id){
        return cartService.deleteCart(id);
    }
}
