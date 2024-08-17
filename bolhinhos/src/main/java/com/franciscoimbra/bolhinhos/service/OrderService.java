package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.OrderDTO;
import com.franciscoimbra.bolhinhos.dto.OrderRecipeDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Order;
import com.franciscoimbra.bolhinhos.model.Order;
import com.franciscoimbra.bolhinhos.model.OrderRecipe;
import com.franciscoimbra.bolhinhos.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        Order.class,
                        OrderDTO.class)
                .addMapping(Order::getId, OrderDTO::setId);
    }
    public OrderDTO create(OrderDTO order) {
        var entity = mapper.map(order, Order.class);
        return mapper.map(repository.save(entity), OrderDTO.class);
    }

    public OrderDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, OrderDTO.class);
    }

    public List<OrderDTO> findAll() {
        return repository.findAll().stream()
                .map(order -> {
                    OrderDTO orderDTO = mapper.map(order, OrderDTO.class);
                    orderDTO.add(linkTo(methodOn(AddressController.class).findById(orderDTO.getId())).withSelfRel());
                    return orderDTO;
                })
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    public OrderDTO update(OrderDTO order) {
        var entity = repository.findById(order.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setPickupDate(order.getPickupDate());
        entity.setPickupPoint(order.getPickupPoint());
        var vo =  mapper.map(repository.save(entity), OrderDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }
}

