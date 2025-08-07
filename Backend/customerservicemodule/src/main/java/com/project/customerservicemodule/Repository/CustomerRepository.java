package com.project.customerservicemodule.Repository;

import com.project.customerservicemodule.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>
{
    Customer findTopByOrderByCustCodeDesc();
}
