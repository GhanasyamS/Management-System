package com.project.employeeservicemodule.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employee_id", nullable = false, updatable = false)
    private UUID employeeId;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Personal email is required")
    @Email(message = "Enter a valid email address")
    @Column(name = "personal_email", nullable = false, unique = true)
    private String personalEmail;

    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "Address is required")
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "Designation is required")
    @Column(name = "designation", nullable = false)
    private String designation;

    @Min(value = 0, message = "Experience cannot be negative")
    @Column(name = "experience_years", nullable = false)
    private int experienceYears;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "per_hour_charge")
    private double perHourCharge;

    @Column(name = "em_category")
    private String emCategory;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Column(name = "personal_mobile")
    private String personalMobile;

    @Email(message = "Enter a valid company email address")
    @Column(name = "company_email", unique = true)
    private String companyEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Column(name = "company_mobile")
    private String companyMobile;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;


    public Employee(UUID employeeId, String name, String personalEmail, LocalDate dateOfBirth, String address,
                    String designation, int experienceYears, String bloodGroup, double perHourCharge, String emCategory,
                    String personalMobile, String companyEmail,
                    String companyMobile, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.personalEmail = personalEmail;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.designation = designation;
        this.experienceYears = experienceYears;
        this.bloodGroup = bloodGroup;
        this.perHourCharge = perHourCharge;
        this.emCategory = emCategory;
        this.personalMobile = personalMobile;
        this.companyEmail = companyEmail;
        this.companyMobile = companyMobile;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Employee() {
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public double getPerHourCharge() {
        return perHourCharge;
    }

    public void setPerHourCharge(double perHourCharge) {
        this.perHourCharge = perHourCharge;
    }

    public String getEmCategory() {
        return emCategory;
    }

    public void setEmCategory(String emCategory) {
        this.emCategory = emCategory;
    }

    public String getPersonalMobile() {
        return personalMobile;
    }

    public void setPersonalMobile(String personalMobile) {
        this.personalMobile = personalMobile;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", designation='" + designation + '\'' +
                ", experienceYears=" + experienceYears +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", perHourCharge=" + perHourCharge +
                ", emCategory='" + emCategory + '\'' +
                ", personalMobile='" + personalMobile + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyMobile='" + companyMobile + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
