package com.tickets.Tickets.repository;

import com.tickets.Tickets.repository.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {
}
