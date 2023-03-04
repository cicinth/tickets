package com.tickets.Tickets.web.controller;

import com.tickets.Tickets.domain.service.SalesService;
import com.tickets.Tickets.web.dto.request.SalesRequest;
import com.tickets.Tickets.web.dto.response.SalesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesTicketController {
    @Autowired
    SalesService salesService;

    @PostMapping
    public ResponseEntity<SalesResponse> createSale(@RequestBody SalesRequest salesRequest){
        SalesResponse createdSale = salesService.createSale(salesRequest);
        return ResponseEntity.created(URI.create("/sales/"+ createdSale.getId())).body(createdSale);
    }

    @GetMapping
    public ResponseEntity<List<SalesResponse>> getAllSales(){
        List<SalesResponse> salesResponse = salesService.getAllSales();
        return ResponseEntity.ok(salesResponse);
    }
}
