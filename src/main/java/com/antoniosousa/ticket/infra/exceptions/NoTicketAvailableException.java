package com.antoniosousa.ticket.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoTicketAvailableException extends RuntimeException {

    public NoTicketAvailableException(String message) {
        super(message);
    }

}
