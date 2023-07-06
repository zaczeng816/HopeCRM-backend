package com.hopefund.crm.repositories;

import com.hopefund.crm.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findById(long id);
    Client findByPhone(String phone);
    List<Client> findAllByName(String name);

}
