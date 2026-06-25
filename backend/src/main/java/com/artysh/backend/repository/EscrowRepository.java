package com.artysh.backend.repository;

import com.artysh.backend.entity.Escrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EscrowRepository extends JpaRepository<Escrow, UUID> {
}
