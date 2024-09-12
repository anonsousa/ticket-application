package com.antoniosousa.ticket.controller;

import com.antoniosousa.ticket.domain.dto.event.EventRequestDto;
import com.antoniosousa.ticket.domain.dto.event.EventResponseDto;
import com.antoniosousa.ticket.domain.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody @Valid EventRequestDto eventRequest) {
        EventResponseDto eventEntity = eventService.createEvent(eventRequest);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(eventEntity.getId())
                        .toUri())
                .body(eventEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findEventById(id));
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        return ResponseEntity.ok(eventService.findAllEvents());
    }
}
