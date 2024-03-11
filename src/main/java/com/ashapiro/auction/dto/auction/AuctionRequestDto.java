package com.ashapiro.auction.dto.auction;

import lombok.Data;

@Data
public class AuctionRequestDto {
    private String productName;
    private String ownerEmail;
    private String status;
}
