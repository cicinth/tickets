package com.tickets.Tickets.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "sales")
public class SalesEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String clientName;
    private Integer eventId;

}
