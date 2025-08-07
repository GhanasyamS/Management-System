package com.project.customerservicemodule.Service;

import com.project.customerservicemodule.Domain.Customer;
import com.project.customerservicemodule.Exception.CustomerNotFoundException;
import com.project.customerservicemodule.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements ICustomerService
{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        String nextCode;

        Customer latestCustomer = customerRepository.findTopByOrderByCustCodeDesc();

        if (latestCustomer == null) {
            nextCode = "CUS0001";
        } else {
            nextCode = generateNextCustCode(latestCustomer.getCustCode());
        }

        customer.setCustCode(nextCode);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        return customerRepository.save(customer);
    }


    @Override
    public Customer getCustomerById(UUID customerId)
    {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(UUID customerId, Customer updatedCustomer)
    {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        existingCustomer.setCustName(updatedCustomer.getCustName());
        existingCustomer.setCustAddress(updatedCustomer.getCustAddress());
        existingCustomer.setUpdatedBy(updatedCustomer.getUpdatedBy());
        existingCustomer.setUpdatedAt(updatedCustomer.getUpdatedAt());


        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(UUID customerId)
    {
        if (!customerRepository.existsById(customerId)) {
            throw new EntityNotFoundException("Customer not found");
        }
        customerRepository.deleteById(customerId);
    }

    private String generateNextCustCode(String prevCode)
    {
            int versionNumber = Integer.parseInt((prevCode.substring(3)));
            versionNumber++;
            return String.format("CUS%04d",versionNumber);

    }
}
