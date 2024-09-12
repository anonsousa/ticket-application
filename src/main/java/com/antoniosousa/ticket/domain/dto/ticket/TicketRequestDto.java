package com.antoniosousa.ticket.domain.dto.ticket;

import com.antoniosousa.ticket.domain.enums.Category;
import com.antoniosousa.ticket.domain.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TicketRequestDto (
        @NotNull Long idUser,
        @NotNull Long idEvent,
        @NotNull BigDecimal price,
        @NotNull Category category,
        @NotNull PaymentMethod paymentMethod
){ }
