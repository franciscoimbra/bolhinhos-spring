package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.ClientUserDTO;
import com.franciscoimbra.bolhinhos.dto.CustomerOrderDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.CustomerOrder;
import com.franciscoimbra.bolhinhos.repository.ClientUserRepository;
import com.franciscoimbra.bolhinhos.repository.CustomerOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CustomerOrderService {
    @Autowired
    CustomerOrderRepository customerOrderRepository;
    private static ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        CustomerOrder.class,
                        ClientUserDTO.class)
                .addMapping(CustomerOrder::getId, ClientUserDTO::setId);
    }
    public CustomerOrderDTO create(CustomerOrderDTO customerOrder) {
        var entity = mapper.map(customerOrder, CustomerOrder.class);
        var vo = mapper.map(customerOrderRepository.save(entity), CustomerOrderDTO.class);
        return vo;
    }
    public List<CustomerOrderDTO> findAll() {
        return customerOrderRepository.findAll().stream()
                .map(customerOrder -> {
                    CustomerOrderDTO clientUserDTO = mapper.map(customerOrder, CustomerOrderDTO.class);
                    clientUserDTO.add(linkTo(methodOn(AddressController.class).findById(clientUserDTO.getId())).withSelfRel());
                    return clientUserDTO;
                })
                .collect(Collectors.toList());
    }
    public CustomerOrderDTO findById(Long id) {

        var entity = customerOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, CustomerOrderDTO.class);
    }

    public void delete(Long id) {
        CustomerOrder entity = customerOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        customerOrderRepository.delete(entity);
    }
}
