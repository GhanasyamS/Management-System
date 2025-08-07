package com.project.projectservicemodule.Domain;

import java.time.LocalDateTime;

public class VersionHistory
{
    private String version;
    private LocalDateTime timestamp;
    private String action;

    public VersionHistory(String version, LocalDateTime timestamp, String action)
    {
        this.version = version;
        this.timestamp = timestamp;
        this.action = action;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "VersionHistory{" +
                "version='" + version + '\'' +
                ", timestamp=" + timestamp +
                ", action='" + action + '\'' +
                '}';
    }
}
