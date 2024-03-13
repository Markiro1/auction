package com.ashapiro.auction.controller;

import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.dto.product.ProductWithEmailDto;
import com.ashapiro.auction.dto.product.SimpleProductDto;
import com.ashapiro.auction.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public void add(@RequestBody ProductWithEmailDto productWithEmailDto) {
        productService.add(productWithEmailDto);
    }

    @GetMapping("/all")
    public List<ProductWithEmailDto> getAll() {
        return productService.getAllProductsWithUserEmail();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Product with id: %d does not exists", id)));
    }

    @GetMapping("/user/{id}")
    public List<SimpleProductDto> getProductsByUserId(@PathVariable Long id) {
        return productService.getProductsByUserId(id);
    }
}
