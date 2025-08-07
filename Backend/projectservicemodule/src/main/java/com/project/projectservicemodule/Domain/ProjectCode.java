package com.project.projectservicemodule.Domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProjectCode
{

    private String latestVersion;
    private List<VersionHistory> history = new ArrayList<>();

    public void createInitialVersion(String customerCode)
    {
        String version = generateVersion(customerCode, 1, 'A');
        this.latestVersion = version;
        this.history.add(new VersionHistory(version, LocalDateTime.now(), "created"));
    }

    public void updateVersion(String customerCode, int newSerial, char suffix)
    {
        String version = generateVersion(customerCode, newSerial, suffix);
        this.latestVersion = version;
        this.history.add(new VersionHistory(version, LocalDateTime.now(), "updated"));
    }

    private String generateVersion(String customerCode, int serial, char suffix)
    {
        return String.format("%s.%04d%c", customerCode, serial, suffix);
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public List<VersionHistory> getHistory() {
        return history;
    }

    public void setHistory(List<VersionHistory> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "ProjectCode{" +
                "latestVersion='" + latestVersion + '\'' +
                ", history=" + history +
                '}';
    }
}
