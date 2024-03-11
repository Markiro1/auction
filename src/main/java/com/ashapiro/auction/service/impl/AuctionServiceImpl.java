package com.ashapiro.auction.service.impl;

import com.ashapiro.auction.dto.auction.AuctionDto;
import com.ashapiro.auction.dto.auction.AuctionRequestDto;
import com.ashapiro.auction.entity.Auction;
import com.ashapiro.auction.entity.Product;
import com.ashapiro.auction.entity.User;
import com.ashapiro.auction.enums.AuctionStatus;
import com.ashapiro.auction.repository.AuctionRepository;
import com.ashapiro.auction.repository.CustomUserRepository;
import com.ashapiro.auction.service.AuctionService;
import com.ashapiro.auction.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final CustomUserRepository customUserRepository;
    private final ProductService productService;

    @Transactional
    @Override
    public void add(AuctionRequestDto auctionRequestDto) {
        User user = customUserRepository.getUserFetchRolesAndProducts(auctionRequestDto.getOwnerEmail())
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email: %s does not exists",
                        auctionRequestDto.getOwnerEmail())));

        Product product = productService.getProductByUserAndName(user, auctionRequestDto.getProductName())
                .orElseThrow(() -> new NoSuchElementException(String.format("Product with name: %s does not exists",
                        auctionRequestDto.getProductName())));

        Auction auction = new Auction();
        auction.addProduct(product);
        auction.setStatus(AuctionStatus.valueOf(auctionRequestDto.getStatus()));
        auctionRepository.save(auction);
    }

    @Override
    public List<AuctionDto> getAllAuctions() {
        return auctionRepository.findAllAuctions();
    }
}
