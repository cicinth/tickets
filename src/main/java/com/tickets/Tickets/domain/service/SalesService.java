package com.tickets.Tickets.domain.service;


import com.tickets.Tickets.domain.utils.SalesConvertUtils;
import com.tickets.Tickets.infra.Gateway.EventGateway;
import com.tickets.Tickets.infra.client.EventClient;
import com.tickets.Tickets.infra.models.EventResponse;
import com.tickets.Tickets.repository.SalesRepository;
import com.tickets.Tickets.repository.entity.SalesEntity;
import com.tickets.Tickets.web.dto.request.SalesRequest;
import com.tickets.Tickets.web.dto.response.SalesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    EventGateway eventGateway;

    public SalesResponse createSale(SalesRequest salesRequest){
        SalesEntity salesEntity = SalesConvertUtils.toEntity(salesRequest);
        EventResponse eventResponse = eventGateway.findEvent(salesRequest.getEventId());
        if(eventResponse.getTicketsSold() >= eventResponse.getTotalAmountTickets()) return null;
        return SalesConvertUtils.toResponse(salesRepository.save(salesEntity));
    }

    public List<SalesResponse> getAllSales(){
        List<SalesEntity> sales = salesRepository.findAll();
        return sales.stream().map(SalesConvertUtils::toResponse).collect(Collectors.toList());
    }
}
