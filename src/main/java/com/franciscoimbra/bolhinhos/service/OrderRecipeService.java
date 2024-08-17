package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientDTO;
import com.franciscoimbra.bolhinhos.dto.OrderRecipeDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.OrderRecipe;
import com.franciscoimbra.bolhinhos.model.Client;
import com.franciscoimbra.bolhinhos.model.OrderRecipe;
import com.franciscoimbra.bolhinhos.repository.OrderRecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class OrderRecipeService {

    @Autowired
    OrderRecipeRepository repository;

    public OrderRecipeService(OrderRecipeRepository repository) {
        this.repository = repository;
    }

    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        OrderRecipe.class,
                        OrderRecipeDTO.class)
                .addMapping(OrderRecipe::getId, OrderRecipeDTO::setId);
    }
    public OrderRecipeDTO create(OrderRecipeDTO orderRecipe) {
        var entity = mapper.map(orderRecipe, OrderRecipe.class);
        return mapper.map(repository.save(entity), OrderRecipeDTO.class);
    }

    public OrderRecipeDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, OrderRecipeDTO.class);
    }

    public List<OrderRecipeDTO> findAll() {
        return repository.findAll().stream()
                .map(orderRecipe -> {
                    OrderRecipeDTO orderRecipeDTO = mapper.map(orderRecipe, OrderRecipeDTO.class);
                    orderRecipeDTO.add(linkTo(methodOn(AddressController.class).findById(orderRecipeDTO.getId())).withSelfRel());
                    return orderRecipeDTO;
                })
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        OrderRecipe entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    public OrderRecipeDTO update(OrderRecipeDTO orderRecipe) {
        var entity = repository.findById(orderRecipe.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setOrderStatus(orderRecipe.getOrderStatus());
        entity.setQuantity(orderRecipe.getQuantity());

        var vo =  mapper.map(repository.save(entity), OrderRecipeDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }
}

