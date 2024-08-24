package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.dto.OrderDTO;
import com.franciscoimbra.bolhinhos.service.EstablishmentService;
import com.franciscoimbra.bolhinhos.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order/v1")
@Tag(name = "order", description = "endpoints da order")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping
    public List<OrderDTO> findAll() {
        return service.findAll();
    }
    @GetMapping("/{date}")
    public OrderDTO findByPickupDate(@PathVariable("date") Date date) {
        return service.findBypickupdate(date);
    }
    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return service.create(orderDTO);
    }
    @PutMapping
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        return service.update(orderDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
