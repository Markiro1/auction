package com.ashapiro.auction.service;

import com.ashapiro.auction.dto.auction.AuctionDto;
import com.ashapiro.auction.dto.auction.AuctionRequestDto;

import java.util.List;

public interface AuctionService {
    void add(AuctionRequestDto auctionRequestDto);

    List<AuctionDto> getAllAuctions();
}
