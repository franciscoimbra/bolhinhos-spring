package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;

import com.franciscoimbra.bolhinhos.dto.OrderItemDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.OrderItem;

import com.franciscoimbra.bolhinhos.repository.OrderItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                        OrderItem.class,
                        OrderItemDTO.class)
                .addMapping(OrderItem::getId, OrderItemDTO::setId);
    }

    public OrderItemDTO create(OrderItemDTO orderItemDTO) {
        var entity = mapper.map(orderItemDTO, OrderItem.class);
        var vo = mapper.map(orderItemRepository.save(entity), OrderItemDTO.class);
        return vo;
    }

    public List<OrderItemDTO> findAll() {

        return orderItemRepository.findAll().stream()
                .map(orderItemDTO -> {
                    OrderItemDTO establishmentDTO = mapper.map(orderItemDTO, OrderItemDTO.class);
                    establishmentDTO.add(linkTo(methodOn(AddressController.class).findById(establishmentDTO.getId())).withSelfRel());
                    return establishmentDTO;
                })
                .collect(Collectors.toList());
    }

    public OrderItemDTO findById(Long id) {

        var entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, OrderItemDTO.class);
    }

    public void delete(Long id) {
        OrderItem entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        orderItemRepository.delete(entity);
    }
}
