package com.project.usereservicemodule.Repository;

import com.project.usereservicemodule.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    User findByUserName(String userName);
}
