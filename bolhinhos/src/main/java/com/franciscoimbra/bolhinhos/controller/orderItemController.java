package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.OrderItemDTO;
import com.franciscoimbra.bolhinhos.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderitem/v1")
public class orderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItemDTO> findAll() {
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
    public OrderItemDTO findById(@PathVariable("id") Long id) {
        return orderItemService.findById(id);
    }

    @PostMapping
    public OrderItemDTO create(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.create(orderItemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        orderItemService.delete(id);
        return ResponseEntity.ok().build();
    }

}
