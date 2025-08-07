package com.project.employeeservicemodule.Controller;

import com.project.employeeservicemodule.Domain.Employee;
import com.project.employeeservicemodule.Exception.EmployeeAlreadyExistsException;
import com.project.employeeservicemodule.Exception.EmployeeNotFoundException;
import com.project.employeeservicemodule.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistsException
    {
        Employee createdEmployee = employeeService.createEmployeeRecord(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") UUID id) throws EmployeeNotFoundException
    {
        Employee employee = employeeService.findEmployeeByEmployeeID(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException
    {
        Employee updatedEmployee = employeeService.updateEmployeeDetailsByID(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") UUID id) throws EmployeeNotFoundException
    {
        employeeService.deleteEmployeeByID(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
