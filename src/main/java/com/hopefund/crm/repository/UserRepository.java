package com.hopefund.crm.repository;

import com.hopefund.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
