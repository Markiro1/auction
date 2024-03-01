package com.ashapiro.auction.repository;

import com.ashapiro.auction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
