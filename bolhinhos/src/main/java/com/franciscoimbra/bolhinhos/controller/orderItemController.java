package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.OrderItemDTO;
import com.franciscoimbra.bolhinhos.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderitem/v1")
public class orderItemController {
    @Autowired
    private OrderItemService orderItemService;


}
