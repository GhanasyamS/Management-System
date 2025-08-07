package com.project.projectservicemodule.Service;

import com.project.projectservicemodule.Domain.Project;

import java.util.List;
import java.util.UUID;

public interface IProjectService
{

    Project createProject(Project project);
    Project getProjectById(UUID projectId);
    List<Project> getAllProjects();
    Project updateProject(UUID projectId, Project project);
    void deleteProject(UUID projectId);

}
