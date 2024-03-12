package dev.shivam.cartservice.dtos;

import dev.shivam.cartservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private Date date;
    private List<Product> products;
}
