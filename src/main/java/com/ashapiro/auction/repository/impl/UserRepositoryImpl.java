package com.ashapiro.auction.repository.impl;

import com.ashapiro.auction.entity.User;
import com.ashapiro.auction.repository.CustomUserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRepositoryImpl implements CustomUserRepository {

    private final EntityManager entityManager;

    @Override
    public Optional<User> getUserFetchRolesAndProducts(String email) {
        var user = entityManager.createQuery(
                        "select u from User u left join fetch u.roles where u.email = ?1",
                        User.class
                )
                .setParameter(1, email)
                .getSingleResult();

        user = entityManager.createQuery(
                        "select u from User u left join fetch u.products where u.id = ?1",
                        User.class
                )
                .setParameter(1, user.getId())
                .getSingleResult();
        return Optional.of(user);
    }
}
