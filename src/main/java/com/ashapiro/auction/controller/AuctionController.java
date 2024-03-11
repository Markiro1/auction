package com.ashapiro.auction.controller;

import com.ashapiro.auction.dto.auction.AuctionDto;
import com.ashapiro.auction.dto.auction.AuctionRequestDto;
import com.ashapiro.auction.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping("/add")
    public void addAuction(@RequestBody AuctionRequestDto auctionDto) {
        auctionService.add(auctionDto);
    }

    @GetMapping("/all")
    public List<AuctionDto> getAll() {
        return auctionService.getAllAuctions();
    }
}
