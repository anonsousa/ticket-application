package com.antoniosousa.ticket.domain.repositories;

import com.antoniosousa.ticket.domain.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE EventEntity e " +
            "SET e.ticketsAvailable = e.ticketsAvailable - 1, " +
            "e.ticketsSubmitted = e.ticketsSubmitted + 1 " +
            "WHERE e.id = :eventId AND e.ticketsAvailable > 0")
    int updateTicketCounts(@Param("eventId") Long eventId);
}
