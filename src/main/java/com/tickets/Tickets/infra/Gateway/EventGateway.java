package com.tickets.Tickets.infra.Gateway;

import com.tickets.Tickets.infra.client.EventClient;
import com.tickets.Tickets.infra.models.EventResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EventGateway {

    @Autowired
    EventClient eventClient;

   @CircuitBreaker(name = "findEvent", fallbackMethod = "findEventFallback")
    public EventResponse findEvent(Integer id){
        return eventClient.findEvent(id);
    }

    private EventResponse findEventFallback(Integer id, Throwable e){
       throw new ResponseStatusException(HttpStatus.NOT_FOUND, "evento não disponivel, tente mais tarde");
    }


}
