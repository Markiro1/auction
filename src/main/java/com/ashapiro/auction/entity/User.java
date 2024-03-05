package com.ashapiro.auction.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "owner")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Bid> bids = new ArrayList<>();

    public void addRole(Role role) {
        role.getUsers().add(this);
        roles.add(role);
    }
}
