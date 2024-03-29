package com.ashapiro.auction.entity;

import com.ashapiro.auction.enums.AuctionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auctions")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuctionStatus status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "auction")
    private List<Bid> bids = new ArrayList<>();

    @Column(nullable = false, name = "created_at")
    private LocalDateTime localDateTime = LocalDateTime.now();

    public void addProduct(Product product) {
        this.product = product;
        product.getAuctions().add(this);
    }
}
