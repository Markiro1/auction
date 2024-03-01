package com.ashapiro.auction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "addresses")
@Getter @Setter
@ToString(exclude = "user")
public class Address {
    @Id
    private Long id;

    private String state;

    private String city;

    private String address;

    private String zip;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

}
