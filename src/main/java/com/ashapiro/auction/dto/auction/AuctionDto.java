package com.ashapiro.auction.dto.auction;

import com.ashapiro.auction.enums.AuctionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
    private Long id;
    private String name;
    private Long productId;
    private String ownerEmail;
    private Long ownerId;
    private AuctionStatus status;
    private LocalDateTime createdAt;
}
