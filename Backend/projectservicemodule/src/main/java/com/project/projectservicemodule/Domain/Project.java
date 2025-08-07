package com.project.projectservicemodule.Domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "project_id", nullable = false, updatable = false)
    private UUID projectId;

    @NotBlank(message = "Job name must not be blank")
    @Column(name = "job_name", nullable = false)
    private String jobName;


    @Type(JsonType.class)
    @Column(name = "pro_code", columnDefinition = "json")
    private ProjectCode proCode;


    @NotNull(message = "Manager ID is required")
    @Column(name = "manager_id", nullable = false)
    private UUID managerId;

    @NotEmpty(message = "At least one employee must be assigned")
    @Type(JsonType.class)
    @Column(name = "assigned_employee_ids", columnDefinition = "json")
    private List<Map<String, Object>> assignedEmployeeIds;

    @Positive(message = "Total cost must be positive")
    @Column(name = "total_cost")
    private Double totalCost;

    @Positive(message = "Total hours must be positive")
    @Column(name = "total_hours")
    private Double totalHours;

    @Positive(message = "Per hour cost must be positive")
    @Column(name = "per_hour_cost")
    private Double perHourCost;

    @NotNull(message = "Project status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @NotNull(message = "Created by is required")
    @Column(name = "created_by", nullable = false)
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;

    public Project(UUID projectId, String jobName, ProjectCode proCode, UUID managerId, List<Map<String, Object>> assignedEmployeeIds, Double totalCost,
                   Double totalHours, Double perHourCost, Status status, LocalDateTime createdAt, LocalDateTime updatedAt, UUID createdBy, UUID updatedBy)
    {
        this.projectId = projectId;
        this.jobName = jobName;
        this.proCode = proCode;
        this.managerId = managerId;
        this.assignedEmployeeIds = assignedEmployeeIds;
        this.totalCost = totalCost;
        this.totalHours = totalHours;
        this.perHourCost = perHourCost;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Project() {
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public ProjectCode getProCode() {
        return proCode;
    }

    public void setProCode(ProjectCode proCode) {
        this.proCode = proCode;
    }

    public UUID getManagerId() {
        return managerId;
    }

    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }

    public List<Map<String, Object>> getAssignedEmployeeIds() {
        return assignedEmployeeIds;
    }

    public void setAssignedEmployeeIds(List<Map<String, Object>> assignedEmployeeIds) {
        this.assignedEmployeeIds = assignedEmployeeIds;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public Double getPerHourCost() {
        return perHourCost;
    }

    public void setPerHourCost(Double perHourCost) {
        this.perHourCost = perHourCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", jobName='" + jobName + '\'' +
                ", proCode=" + proCode +
                ", managerId=" + managerId +
                ", assignedEmployeeIds=" + assignedEmployeeIds +
                ", totalCost=" + totalCost +
                ", totalHours=" + totalHours +
                ", perHourCost=" + perHourCost +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
