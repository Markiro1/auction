package com.ashapiro.auction.service;

import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.dto.product.ProductWithEmailDto;
import com.ashapiro.auction.dto.product.SimpleProductDto;
import com.ashapiro.auction.entity.Product;
import com.ashapiro.auction.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void add(ProductWithEmailDto productWithEmailDto);

    List<ProductWithEmailDto> getAllProductsWithUserEmail();

    Optional<Product> getProductByUserAndName(User user, String name);

    List<SimpleProductDto> getProductsByUserId(Long id);

    Optional<ProductDto> getProductById(Long id);
}
