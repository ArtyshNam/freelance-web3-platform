package com.artysh.backend.controller;

import com.artysh.backend.entity.Proposal;
import com.artysh.backend.service.ProposalService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/proposals")
public class ProposalController {

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GetMapping
    public List<Proposal> getAllProposals() {

        return proposalService.getAllProposals();
    }

    @PostMapping
    public Proposal createProposal(@RequestBody Proposal proposal) {

        return proposalService.createProposal(proposal);
    }

    @PutMapping("/{id}/accept")
    public Proposal acceptProposal(@PathVariable UUID id) {

        return proposalService.acceptProposal(id);
    }
}