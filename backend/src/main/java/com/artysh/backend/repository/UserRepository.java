package com.artysh.backend.repository;

import com.artysh.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByWalletAddress(String walletAddress);

    Optional<User> findByUsername(String username);

}