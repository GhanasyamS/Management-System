package com.project.projectservicemodule.Service;

import com.project.projectservicemodule.Domain.Project;
import com.project.projectservicemodule.Domain.ProjectCode;
import com.project.projectservicemodule.Exception.ProjectNotFoundException;
import com.project.projectservicemodule.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService implements IProjectService
{

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project)
    {
        //assume customer code is CUS001
        project.setCreatedAt(LocalDateTime.now());
        // XXXXXXXXXXXXXXlater add procode details here after testing
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(UUID projectId) throws ProjectNotFoundException {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + projectId));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(UUID projectId, Project updatedProject) {
        return projectRepository.findById(projectId).map(existingProject -> {
            existingProject.setJobName(updatedProject.getJobName());
            existingProject.setManagerId(updatedProject.getManagerId());
            existingProject.setAssignedEmployeeIds(updatedProject.getAssignedEmployeeIds());
            existingProject.setTotalCost(updatedProject.getTotalCost());
            existingProject.setTotalHours(updatedProject.getTotalHours());
            existingProject.setPerHourCost(updatedProject.getPerHourCost());
            existingProject.setStatus(updatedProject.getStatus());
            existingProject.setUpdatedBy(updatedProject.getUpdatedBy());
            existingProject.setUpdatedAt(LocalDateTime.now());

            // Call your logic to update the ProCode
            updateProCode(existingProject);

            return projectRepository.save(existingProject);
        }).orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + projectId));
    }

    @Override
    public void deleteProject(UUID projectId) throws ProjectNotFoundException {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
        }
        projectRepository.deleteById(projectId);
    }

    private void updateProCode(Project project) {
        ProjectCode code = project.getProCode();

        String currentVersion = code.getLatestVersion(); // e.g., "0001.0002B"
        int currentSerial = extractSerial(currentVersion); // Extracts 2
        String customerCode = "0001"; // You can fetch this from customer service later

        int nextSerial = currentSerial + 1;
        char nextSuffix = nextSuffix(currentVersion);

        String nextVersion = String.format("%s.%04d%c", customerCode, nextSerial, nextSuffix);
        code.setLatestVersion(nextVersion);

        project.setProCode(code);
    }

    private int extractSerial(String version)
    {
        // "0001.0002B" -> 2
        String[] parts = version.split("\\.");
        return Integer.parseInt(parts[1].substring(0, 4));
    }
    private char nextSuffix(String version)
    {
        // Get suffix (last char in version)
        char currentSuffix = version.charAt(version.length() - 1);
        return (char) (currentSuffix + 1); // Simple ASCII increment (e.g., B -> C)
    }


}
