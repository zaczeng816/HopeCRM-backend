package com.hopefund.crm.repositories;

import com.hopefund.crm.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(long id);
    Optional<Client> findByPhone(long phone);
    List<Client> findAllByName(String name);

}
