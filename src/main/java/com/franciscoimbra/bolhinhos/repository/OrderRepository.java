package com.franciscoimbra.bolhinhos.repository;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getReferenceByPickupDate(Date date);
}
