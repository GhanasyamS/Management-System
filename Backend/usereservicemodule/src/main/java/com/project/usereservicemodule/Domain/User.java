package com.project.usereservicemodule.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class User
{

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "user_id", nullable = false, updatable = false)
        private UUID userId;

        @NotBlank(message = "User name is required")
        @Column(name = "user_name", unique = true ,nullable = false)
        private String userName;

        @NotBlank(message = "Password is required")
        private String userPassword;

        @NotNull(message = "Employee ID is required")
        @Column(name = "employee_id", nullable = false)
        private UUID employeeId;

        @NotNull(message = "Role is required")
        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false)
        private Role role;

        @Column(name = "last_login")
        private LocalDateTime lastLogin;

        @CreationTimestamp
        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        @Column(name = "created_by")
        private UUID createdBy;

        @Column(name = "updated_by")
        private UUID updatedBy;

        public User() {
        }

        public User(UUID userId, String userName, String userPassword,
                    UUID employeeId, Role role, LocalDateTime lastLogin, LocalDateTime createdAt, LocalDateTime updatedAt, UUID createdBy, UUID updatedBy) {
                this.userId = userId;
                this.userName = userName;
                this.userPassword = userPassword;
                this.employeeId = employeeId;
                this.role = role;
                this.lastLogin = lastLogin;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
                this.createdBy = createdBy;
                this.updatedBy = updatedBy;
        }

        public String getUserPassword() {
                return userPassword;
        }

        public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
        }

        public UUID getUserId() {
                return userId;
        }

        public void setUserId(UUID userId) {
                this.userId = userId;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public UUID getEmployeeId() {
                return employeeId;
        }

        public void setEmployeeId(UUID employeeId) {
                this.employeeId = employeeId;
        }

        public Role getRole() {
                return role;
        }

        public void setRole(Role role) {
                this.role = role;
        }

        public LocalDateTime getLastLogin() {
                return lastLogin;
        }

        public void setLastLogin(LocalDateTime lastLogin) {
                this.lastLogin = lastLogin;
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
                return "User{" +
                        "userId=" + userId +
                        ", userName='" + userName + '\'' +
                        ", employeeId=" + employeeId +
                        ", role=" + role +
                        ", lastLogin=" + lastLogin +
                        ", createdAt=" + createdAt +
                        ", updatedAt=" + updatedAt +
                        ", createdBy=" + createdBy +
                        ", updatedBy=" + updatedBy +
                        '}';
        }
}
