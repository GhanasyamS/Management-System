package com.project.projectservicemodule.Controller;

import com.project.projectservicemodule.Domain.Project;
import com.project.projectservicemodule.Exception.ProjectNotFoundException;
import com.project.projectservicemodule.Service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController
{

    private final IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService)
    {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project)
    {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/findbyid/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable("projectId") UUID projectId) throws ProjectNotFoundException
    {
        Project project = projectService.getProjectById(projectId);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/getallprojects")
    public ResponseEntity<List<Project>> getAllProjects()
    {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable("projectId") UUID projectId, @RequestBody Project updatedProject) throws ProjectNotFoundException
    {
        Project project = projectService.updateProject(projectId, updatedProject);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable("projectId") UUID projectId) throws ProjectNotFoundException {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok("Project deleted successfully.");
    }
}
