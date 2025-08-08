package com.project.auditlogservicemodule.Domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "audit_events")
public class AuditEvent {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Module module;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Action action;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String changedFieldsJson;

    public AuditEvent(UUID id, Module module, Action action, UUID userId, String userName, LocalDateTime modifiedAt, String changedFieldsJson) {
        this.id = id;
        this.module = module;
        this.action = action;
        this.userId = userId;
        this.userName = userName;
        this.modifiedAt = modifiedAt;
        this.changedFieldsJson = changedFieldsJson;
    }

    public AuditEvent() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getChangedFieldsJson() {
        return changedFieldsJson;
    }

    public void setChangedFieldsJson(String changedFieldsJson) {
        this.changedFieldsJson = changedFieldsJson;
    }

    @Override
    public String toString() {
        return "AuditEvent{" +
                "id=" + id +
                ", module=" + module +
                ", action=" + action +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", modifiedAt=" + modifiedAt +
                ", changedFieldsJson='" + changedFieldsJson + '\'' +
                '}';
    }
}
