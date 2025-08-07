package com.project.customerservicemodule.Controller;

import com.project.customerservicemodule.Domain.Customer;
import com.project.customerservicemodule.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController
{

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") UUID id)
    {

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") UUID id, @RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") UUID id)
    {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
