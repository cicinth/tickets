package com.tickets.Tickets.infra.models;

import lombok.Getter;

@Getter
public class EventResponse {
    private Integer id;
    private String eventName;
    private Integer totalAmountTickets;
    private Integer ticketsSold;
}
