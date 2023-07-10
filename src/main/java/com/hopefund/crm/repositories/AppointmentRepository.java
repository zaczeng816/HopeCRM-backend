package com.hopefund.crm.repositories;

import com.hopefund.crm.entities.Appointment;
import com.hopefund.crm.entities.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByClientId(Long clientId);

    @Query("SELECT a FROM Appointment a WHERE a.client.id = :clientId AND a.status != 'COMPLETED' ORDER BY a.time DESC")
    List<Appointment> findTopByClientAndStatusNotOrderByTimeDesc(@Param("clientId") Long clientId);

    List<Appointment> findAllByStatus(AppointmentStatus status);
}
