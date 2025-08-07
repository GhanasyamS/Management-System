package com.project.customerservicemodule.Service;

import com.project.customerservicemodule.Domain.Customer;

import java.util.List;
import java.util.UUID;

public interface ICustomerService
{
    Customer createCustomer(Customer customer);
    Customer getCustomerById(UUID customerId);
    List<Customer> getAllCustomers();
    Customer updateCustomer(UUID customerId, Customer updatedCustomer);
    void deleteCustomer(UUID customerId);
}
