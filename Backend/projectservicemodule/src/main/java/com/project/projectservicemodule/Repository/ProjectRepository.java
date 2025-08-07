package com.project.projectservicemodule.Repository;

import com.project.projectservicemodule.Domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>
{
    Project findByJobName(String jobName);
}
