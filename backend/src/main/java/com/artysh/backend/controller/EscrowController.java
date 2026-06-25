package com.artysh.backend.controller;

import com.artysh.backend.entity.Escrow;
import com.artysh.backend.repository.EscrowRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escrows")
public class EscrowController {

    private final EscrowRepository escrowRepository;

    public EscrowController(EscrowRepository escrowRepository) {
        this.escrowRepository = escrowRepository;
    }

    @GetMapping
    public List<Escrow> getAllEscrows() {
        return escrowRepository.findAll();
    }
}