package com.antoniosousa.ticket.domain.dto.event;

import com.antoniosousa.ticket.domain.enums.EventStatus;
import com.antoniosousa.ticket.domain.model.EventAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventResponseDto {

    private Long id;
    private String eventName;
    private EventAddress address;
    private LocalDateTime eventStartDate;
    private LocalDateTime eventEndDate;
    private BigDecimal price;
    private int capacity;
    private int ticketsAvailable;
    private int ticketsSubmitted;
    private String eventLogo;
    private boolean ownParking;
    private EventStatus eventStatus;

}
