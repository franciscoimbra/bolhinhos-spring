package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.dto.OrderDTO;
import com.franciscoimbra.bolhinhos.service.EstablishmentService;
import com.franciscoimbra.bolhinhos.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    @GetMapping("/date/{date}")
    public List<OrderDTO> findById(@PathVariable("date") LocalDate date) {
        return service.findBypickupdate(date);
    }
}
