package com.antoniosousa.ticket.controller;

import com.antoniosousa.ticket.domain.dto.ticket.TicketRequestDto;
import com.antoniosousa.ticket.domain.dto.ticket.TicketResponseDto;
import com.antoniosousa.ticket.domain.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody @Valid TicketRequestDto ticket) {
        TicketResponseDto ticketResponseDto = ticketService.createTicket(ticket);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(ticketResponseDto.ticketId())
                        .toUri())
                .body(ticketResponseDto);
    }

}
