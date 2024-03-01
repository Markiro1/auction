package com.ashapiro.auction.repository;

import com.ashapiro.auction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
