package com.ashapiro.auction.repository;

import com.ashapiro.auction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
