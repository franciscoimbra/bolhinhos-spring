package com.franciscoimbra.bolhinhos.controller;
import com.franciscoimbra.bolhinhos.dto.CustomerOrderDTO;
import com.franciscoimbra.bolhinhos.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerorder/v1")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping
    public List<CustomerOrderDTO> findAll() {
        return customerOrderService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerOrderDTO findById(@PathVariable("id") Long id) {
        return customerOrderService.findById(id);
    }

    @PostMapping
    public CustomerOrderDTO create(@RequestBody CustomerOrderDTO customerOrderDTO) {
        return customerOrderService.create(customerOrderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        customerOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
