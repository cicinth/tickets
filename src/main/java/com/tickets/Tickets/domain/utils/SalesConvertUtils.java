package com.tickets.Tickets.domain.utils;

import com.tickets.Tickets.repository.entity.SalesEntity;
import com.tickets.Tickets.web.dto.request.SalesRequest;
import com.tickets.Tickets.web.dto.response.SalesResponse;

public class SalesConvertUtils {
    public static SalesResponse toResponse(SalesEntity saleEntity){
        SalesResponse response = new SalesResponse();
        response.setId(saleEntity.getId());
        response.setClientName(saleEntity.getClientName());
        response.setEventId(saleEntity.getEventId());
        return response;
    }

    public static SalesEntity toEntity(SalesRequest salesRequest){
        SalesEntity entity = new SalesEntity();
        entity.setClientName(salesRequest.getClientName());
        entity.setEventId(salesRequest.getEventId());
        return entity;
    }
}
