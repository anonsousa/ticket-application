package com.antoniosousa.ticket.domain.model;

import com.antoniosousa.ticket.domain.enums.EventStatus;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;

    @Embedded
    private EventAddress address;


    @FutureOrPresent
    private LocalDateTime eventStartDate;
    @FutureOrPresent
    private LocalDateTime eventEndDate;

    private BigDecimal price;
    private int capacity;
    private int ticketsAvailable;
    private int ticketsSubmitted;
    private String eventLogo;
    private boolean ownParking;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

}

