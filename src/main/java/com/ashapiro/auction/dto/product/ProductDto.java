package com.ashapiro.auction.dto.product;

import com.ashapiro.auction.enums.ProductStatus;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {
    private String name;
    private Long quantity;
    private BigDecimal askingPrice;
    private ProductStatus status;
    private String description;
    private String email;
}
