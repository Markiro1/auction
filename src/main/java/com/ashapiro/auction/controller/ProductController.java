package com.ashapiro.auction.controller;

import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public void add(@RequestBody ProductDto productDto) {
        productService.add(productDto);
    }

    @GetMapping("/all")
    public List<ProductDto> getAll() {
        return productService.getAllProductsWithUserEmail();
    }
}
