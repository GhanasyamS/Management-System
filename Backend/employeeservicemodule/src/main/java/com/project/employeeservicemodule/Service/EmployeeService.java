package com.project.employeeservicemodule.Service;

import com.project.employeeservicemodule.Domain.Employee;
import com.project.employeeservicemodule.Exception.EmployeeAlreadyExistsException;
import com.project.employeeservicemodule.Exception.EmployeeNotFoundException;
import com.project.employeeservicemodule.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployeeRecord(Employee employee) throws EmployeeAlreadyExistsException
    {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee findEmployeeByEmployeeID(UUID employeeID) throws EmployeeNotFoundException
    {
        return employeeRepository.findById(employeeID)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with employee ID: "+employeeID));
    }

    @Override
    public Employee updateEmployeeDetailsByID(Employee employee) throws EmployeeNotFoundException
    {
        return employeeRepository.findById(employee.getEmployeeId())
                .map(existingEmployee ->{
                    existingEmployee.setName(employee.getName());
                    existingEmployee.setPersonalEmail(employee.getPersonalEmail());
                    existingEmployee.setDateOfBirth(employee.getDateOfBirth());
                    existingEmployee.setAddress(employee.getAddress());
                    existingEmployee.setDesignation(employee.getDesignation());
                    existingEmployee.setExperienceYears(employee.getExperienceYears());
                    existingEmployee.setBloodGroup(employee.getBloodGroup());
                    existingEmployee.setPerHourCharge(employee.getPerHourCharge());
                    existingEmployee.setEmCategory(employee.getEmCategory());
                    existingEmployee.setPersonalMobile(employee.getPersonalMobile());
                    existingEmployee.setCompanyEmail(employee.getCompanyEmail());
                    existingEmployee.setCompanyMobile(employee.getCompanyMobile());
                    existingEmployee.setUpdatedAt(LocalDateTime.now());
                    existingEmployee.setUpdatedBy(employee.getUpdatedBy());

                    return employeeRepository.save(existingEmployee);
                })
                .orElseThrow(()->new EmployeeNotFoundException("Employee not found with employeeID : " + employee.getEmployeeId()));
    }

    @Override
    public void deleteEmployeeByID(UUID employeeID) throws EmployeeNotFoundException
    {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(() ->new EmployeeNotFoundException("Employee not found with Employee ID : "+employeeID));

        employeeRepository.deleteById(employeeID);
    }


}
