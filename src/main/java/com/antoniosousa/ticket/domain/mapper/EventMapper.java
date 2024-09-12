package com.antoniosousa.ticket.domain.mapper;

import com.antoniosousa.ticket.domain.dto.event.EventRequestDto;
import com.antoniosousa.ticket.domain.dto.event.EventResponseDto;
import com.antoniosousa.ticket.domain.model.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eventName", source = "eventName")
    @Mapping(target = "address.zip", source = "address.zip")
    @Mapping(target = "address.street", source = "address.street")
    @Mapping(target = "address.number", source = "address.number")
    @Mapping(target = "address.city", source = "address.city")
    @Mapping(target = "address.state", source = "address.state")
    @Mapping(target = "address.country", source = "address.country")
    @Mapping(target = "eventStartDate", source = "eventStartDate")
    @Mapping(target = "eventEndDate", source = "eventEndDate")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "ticketsAvailable", source = "ticketsAvailable")
    @Mapping(target = "ticketsSubmitted", ignore = true)
    @Mapping(target = "eventLogo", source = "eventLogo")
    @Mapping(target = "ownParking", source = "ownParking")
    @Mapping(target = "eventStatus", ignore = true)
    EventEntity toEntity(EventRequestDto eventRequestDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "eventName", source = "eventName")
    @Mapping(target = "address.zip", source = "address.zip")
    @Mapping(target = "address.street", source = "address.street")
    @Mapping(target = "address.number", source = "address.number")
    @Mapping(target = "address.city", source = "address.city")
    @Mapping(target = "address.state", source = "address.state")
    @Mapping(target = "address.country", source = "address.country")
    @Mapping(target = "eventStartDate", source = "eventStartDate")
    @Mapping(target = "eventEndDate", source = "eventEndDate")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "ticketsAvailable", source = "ticketsAvailable")
    @Mapping(target = "ticketsSubmitted", source = "ticketsSubmitted")
    @Mapping(target = "eventLogo", source = "eventLogo")
    @Mapping(target = "ownParking", source = "ownParking")
    @Mapping(target = "eventStatus", source = "eventStatus")
    EventResponseDto toDto(EventEntity eventEntity);

    List<EventResponseDto> toDtoList(List<EventEntity> events);
}
