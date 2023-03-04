package com.tickets.Tickets.infra.client;

import com.tickets.Tickets.infra.models.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("events")
public interface EventClient {
    @GetMapping("/events/{id}")
    EventResponse findEvent(@PathVariable Integer id);
}

