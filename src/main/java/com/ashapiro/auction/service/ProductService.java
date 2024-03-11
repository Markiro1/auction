package com.ashapiro.auction.service;

import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.entity.Product;
import com.ashapiro.auction.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void add(ProductDto productDto);

    List<ProductDto> getAllProductsWithUserEmail();

    Optional<Product> getProductByUserAndName(User user, String name);
}
