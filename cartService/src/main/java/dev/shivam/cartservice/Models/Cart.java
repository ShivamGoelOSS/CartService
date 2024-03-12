package dev.shivam.cartservice.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter

public class Cart {
        private Long id;
        private Long userId;
        private Date date;
        private List<Product> products;
}

