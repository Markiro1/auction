package com.ashapiro.auction.repository;

import com.ashapiro.auction.dto.auction.AuctionDto;
import com.ashapiro.auction.dto.product.ProductDto;
import com.ashapiro.auction.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepository  extends JpaRepository<Auction, Long> {

    @Query("select new com.ashapiro.auction.dto.auction.AuctionDto(" +
            "a.id, " +
            "p.name, " +
            "p.id, " +
            "u.email, " +
            "u.id, " +
            "a.status," +
            "a.localDateTime as createdAt"+
            ") from Auction a " +
            "left join a.product p " +
            "left join p.owner u")
    List<AuctionDto> findAllAuctions();
}
