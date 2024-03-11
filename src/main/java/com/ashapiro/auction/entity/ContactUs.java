package com.ashapiro.auction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact_us")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "description_of_goods")
    private String descriptionOfGoods;
}
