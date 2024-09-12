package com.antoniosousa.ticket.domain.model;

import com.antoniosousa.ticket.domain.enums.Category;
import com.antoniosousa.ticket.domain.enums.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Positive
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDateTime purchasedAt;

}
