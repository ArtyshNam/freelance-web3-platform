package com.artysh.backend.service;

import com.artysh.backend.entity.Project;
import com.artysh.backend.entity.Proposal;
import com.artysh.backend.entity.Escrow;
import com.artysh.backend.entity.enums.EscrowStatus;
import com.artysh.backend.repository.EscrowRepository;
import com.artysh.backend.entity.enums.ProjectStatus;
import com.artysh.backend.entity.enums.ProposalStatus;
import com.artysh.backend.repository.ProjectRepository;
import com.artysh.backend.repository.ProposalRepository;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ProposalService {


    private final ProposalRepository proposalRepository;
    private final ProjectRepository projectRepository;
    private final EscrowRepository escrowRepository;

    public ProposalService(
            ProposalRepository proposalRepository,
            ProjectRepository projectRepository,
            EscrowRepository escrowRepository
    ) {
        this.proposalRepository = proposalRepository;
        this.projectRepository = projectRepository;
        this.escrowRepository = escrowRepository;
    }

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Proposal createProposal(Proposal proposal) {

        proposal.setCreatedAt(Instant.now());

        return proposalRepository.save(proposal);
    }

    public Proposal acceptProposal(UUID proposalId) {

        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow();

        proposal.setStatus(ProposalStatus.ACCEPTED);

        Project project = proposal.getProject();

        project.setStatus(ProjectStatus.IN_PROGRESS);

        projectRepository.save(project);

        Escrow escrow = new Escrow();

        escrow.setProject(project);

        escrow.setAmount(project.getBudget());

        escrow.setStatus(EscrowStatus.CREATED);

        escrowRepository.save(escrow);

        return proposalRepository.save(proposal);
    }
}