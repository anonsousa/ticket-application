package com.antoniosousa.ticket.domain.service;

import com.antoniosousa.ticket.domain.dto.ticket.TicketRequestDto;
import com.antoniosousa.ticket.domain.dto.ticket.TicketResponseDto;
import com.antoniosousa.ticket.domain.model.EventEntity;
import com.antoniosousa.ticket.domain.model.TicketEntity;
import com.antoniosousa.ticket.domain.model.UserEntity;
import com.antoniosousa.ticket.domain.repositories.TicketRepository;
import com.antoniosousa.ticket.domain.repositories.UserRepository;
import com.antoniosousa.ticket.infra.exceptions.ItemNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final EventService eventService;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, EventService eventService) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.eventService = eventService;
    }

    @Transactional
    public TicketResponseDto createTicket(TicketRequestDto ticketRequestDto) {

        EventEntity event = eventService.findEvent(ticketRequestDto.idEvent());

        UserEntity user = userRepository
                .findById(ticketRequestDto.idUser())
                .orElseThrow(() -> new ItemNotFoundException("User not found"));

        TicketEntity ticket = new TicketEntity();

        BeanUtils.copyProperties(ticketRequestDto, ticket, "idUser", "idEvent");

        ticket.setUser(user);
        ticket.setEvent(event);
        ticket.setPurchasedAt(LocalDateTime.now().withNano(0));

        TicketEntity ticketSaved = ticketRepository.save(ticket);

        if (ticketSaved.getId() != null) {
            eventService.manageEventTicket(event.getId());
        }
        return new TicketResponseDto(
                ticketSaved.getId(),
                ticketSaved.getEvent().getId(),
                ticketSaved.getUser().getId(),
                ticketSaved.getPrice(),
                ticketSaved.getCategory(),
                ticketSaved.getPaymentMethod(),
                ticketSaved.getPurchasedAt()
        );
    }

    @Transactional(readOnly = true)
    public TicketResponseDto getTicket(Long id) {
        TicketEntity ticket = ticketRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Ticket not found"));

        return new TicketResponseDto(
                ticket.getId(),
                ticket.getEvent().getId(),
                ticket.getUser().getId(),
                ticket.getPrice(),
                ticket.getCategory(),
                ticket.getPaymentMethod(),
                ticket.getPurchasedAt());
    }

}
