package com.project.timesheetservicemodule.Domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TimeSheet
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "timesheet_id", updatable = false, nullable = false)
    private UUID timeSheetId;

    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    @Column(name = "project_name", nullable = false)
    private String projectName;

//    @Column(name = "project_code", nullable = false)
//    private String projectCode;

    @Column(name = "employee_id", nullable = false)
    private UUID employeeId;

    @Column(name = "work_date", nullable = false)
    private LocalDate date;

    @Column(name = "hours", nullable = false)
    private double hours;

    @Column(name = "week_start", nullable = false)
    private LocalDate weekStart;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "total_week_hours", nullable = false)
    private double totalWeekHours;

    @Column(name = "created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_by", nullable = false,updatable = false)
    private UUID createdBy;

    @Column(name = "updated_by", nullable = false)
    private UUID updatedBy;

    public TimeSheet(UUID timeSheetId, UUID projectId, String projectName, UUID employeeId, LocalDate date, double hours,
                     LocalDate weekStart, Status status, double totalWeekHours, LocalDateTime createdAt, LocalDateTime updatedAt, UUID createdBy, UUID updatedBy) {
        this.timeSheetId = timeSheetId;
        this.projectId = projectId;
        this.projectName = projectName;
//        this.projectCode = projectCode;
        this.employeeId = employeeId;
        this.date = date;
        this.hours = hours;
        this.weekStart = weekStart;
        this.status = status;
        this.totalWeekHours = totalWeekHours;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public TimeSheet() {
    }

    public UUID getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(UUID timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

//    public String getProjectCode() {
//        return projectCode;
//    }
//
//    public void setProjectCode(String projectCode) {
//        this.projectCode = projectCode;
//    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(LocalDate weekStart) {
        this.weekStart = weekStart;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotalWeekHours() {
        return totalWeekHours;
    }

    public void setTotalWeekHours(double totalWeekHours) {
        this.totalWeekHours = totalWeekHours;
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
        return "TimeSheet{" +
                "timeSheetId=" + timeSheetId +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
//                ", projectCode='" + projectCode + '\'' +
                ", employeeId=" + employeeId +
                ", date=" + date +
                ", hours=" + hours +
                ", weekStart=" + weekStart +
                ", status=" + status +
                ", totalWeekHours=" + totalWeekHours +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
