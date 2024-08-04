package com.franciscoimbra.bolhinhos.repository;

import com.franciscoimbra.bolhinhos.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
