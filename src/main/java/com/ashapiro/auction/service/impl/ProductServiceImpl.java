package com.ashapiro.auction.service.impl;

import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.dto.product.ProductWithEmailDto;
import com.ashapiro.auction.dto.product.SimpleProductDto;
import com.ashapiro.auction.entity.Product;
import com.ashapiro.auction.entity.User;
import com.ashapiro.auction.repository.ProductRepository;
import com.ashapiro.auction.service.ProductService;
import com.ashapiro.auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public void add(ProductWithEmailDto productWithEmailDto) {
        Product product = modelMapper.map(productWithEmailDto, Product.class);
        User owner = userService.findByEmail(productWithEmailDto.getEmail()).orElseThrow();
        product.addOwner(owner);
        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductByUserAndName(User user, String name) {
        return productRepository.findProductByOwnerAndName(user, name);
    }

    @Override
    public List<ProductWithEmailDto> getAllProductsWithUserEmail() {
        return productRepository.getAllProductsWithUserEmail();
    }

    @Override
    public List<SimpleProductDto> getProductsByUserId(Long id) {
        return productRepository.findProductByOwnerId(id);
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
