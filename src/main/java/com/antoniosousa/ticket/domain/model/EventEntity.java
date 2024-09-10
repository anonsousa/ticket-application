package com.antoniosousa.ticket.domain.model;

import com.antoniosousa.ticket.domain.enums.EventStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private EventAdress adress;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;


    private BigDecimal price;
    private int capacity;
    private int ticketsAvailable;
    private int ticketsSubmitted;




    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;
















}

