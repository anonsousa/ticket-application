package com.antoniosousa.ticket.domain.model;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class EventAddress {

    @NotBlank
    private String zip;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
}
