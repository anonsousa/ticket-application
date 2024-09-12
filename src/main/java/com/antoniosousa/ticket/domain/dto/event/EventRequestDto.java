package com.antoniosousa.ticket.domain.dto.event;

import com.antoniosousa.ticket.domain.model.EventAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventRequestDto {

    private @NotBlank String eventName;

    private @Valid EventAddress address;

    private @NotNull LocalDateTime eventStartDate;

    private @NotNull LocalDateTime eventEndDate;

    private @NotNull @Positive BigDecimal price;

    private @NotNull @Positive int capacity;

    private @NotNull @Positive int ticketsAvailable;

    private String eventLogo;

    private @NotNull boolean ownParking;

}
