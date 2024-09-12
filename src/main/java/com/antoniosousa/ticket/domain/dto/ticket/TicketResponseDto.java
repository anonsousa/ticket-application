package com.antoniosousa.ticket.domain.dto.ticket;

import com.antoniosousa.ticket.domain.enums.Category;
import com.antoniosousa.ticket.domain.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TicketResponseDto(
        Long ticketId,
        Long eventId,
        Long userId,
        BigDecimal price,
        Category category,
        PaymentMethod paymentMethod,
        LocalDateTime purchasedAt
){ }
