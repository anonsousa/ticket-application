package com.antoniosousa.ticket.domain.service;

import com.antoniosousa.ticket.domain.dto.event.EventRequestDto;
import com.antoniosousa.ticket.domain.dto.event.EventResponseDto;
import com.antoniosousa.ticket.domain.enums.EventStatus;
import com.antoniosousa.ticket.domain.mapper.EventMapper;
import com.antoniosousa.ticket.domain.model.EventEntity;
import com.antoniosousa.ticket.domain.repositories.EventRepository;
import com.antoniosousa.ticket.infra.exceptions.EventNotAvailableException;
import com.antoniosousa.ticket.infra.exceptions.ItemNotFoundException;
import com.antoniosousa.ticket.infra.exceptions.NoTicketAvailableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public EventResponseDto createEvent(EventRequestDto eventDto){
        EventEntity event = EventMapper.INSTANCE.toEntity(eventDto);
        event.setEventStatus(EventStatus.ACTIVE);

        return EventMapper.INSTANCE.toDto(eventRepository.save(event));

    }

    @Transactional(readOnly = true)
    public EventResponseDto findEventById(Long id){
        return EventMapper.INSTANCE.toDto(eventRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found on our database!")));
    }

    @Transactional(readOnly = true)
    public List<EventResponseDto> findAllEvents(){
        return EventMapper.INSTANCE.toDtoList(eventRepository.findAll());
    }

    @Transactional
    public void manageEventTicket(Long eventId) {
        int updatedRows = eventRepository.updateTicketCounts(eventId);

        if (updatedRows == 0) {
            throw new NoTicketAvailableException("No tickets available for this event");
        }
    }

    @Transactional(readOnly = true)
    public EventEntity findEvent(Long id){

        EventEntity event = eventRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Event not found on our database"));

        if (event.getEventStatus() == EventStatus.ACTIVE) {
            return event;
        }
        throw new EventNotAvailableException("Event is not ACTIVE");
    }
















}
