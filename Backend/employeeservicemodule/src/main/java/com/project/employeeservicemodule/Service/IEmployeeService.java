package com.project.employeeservicemodule.Service;

import com.project.employeeservicemodule.Domain.Employee;
import com.project.employeeservicemodule.Exception.EmployeeAlreadyExistsException;
import com.project.employeeservicemodule.Exception.EmployeeNotFoundException;
import com.project.employeeservicemodule.Repository.EmployeeRepository;

import java.util.UUID;

public interface IEmployeeService
{

    Employee createEmployeeRecord(Employee employee) throws EmployeeAlreadyExistsException;
    Employee findEmployeeByEmployeeID(UUID employeeID) throws EmployeeNotFoundException;
    Employee updateEmployeeDetailsByID(Employee employee) throws EmployeeNotFoundException;
    void deleteEmployeeByID(UUID employeeID) throws EmployeeNotFoundException;
}
