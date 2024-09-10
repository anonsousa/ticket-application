package com.antoniosousa.ticket.domain.repositories;

import com.antoniosousa.ticket.domain.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
