package com.artysh.backend.controller;

import com.artysh.backend.entity.Project;
import com.artysh.backend.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {

        project.setCreatedAt(Instant.now());

        return projectRepository.save(project);
    }
}