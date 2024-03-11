package com.ashapiro.auction.repository;

import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.entity.Product;
import com.ashapiro.auction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new com.ashapiro.auction.dto.product.ProductDto(" +
            "p.name, " +
            "p.quantity, " +
            "p.askingPrice, " +
            "p.status, " +
            "p.description, " +
            "p.owner.email"+
            ") from Product p join User u ON u.id = p.owner.id")
    List<ProductDto> getAllProductsWithUserEmail();

    @Query("select p from Product p left join fetch p.auctions where p.owner = :user and p.name = :name")
    Optional<Product> getProductByUserAndName(User user, String name);
}
