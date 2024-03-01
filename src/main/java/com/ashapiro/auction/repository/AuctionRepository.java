package com.ashapiro.auction.repository;

import com.ashapiro.auction.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository  extends JpaRepository<Auction, Long> {
}
