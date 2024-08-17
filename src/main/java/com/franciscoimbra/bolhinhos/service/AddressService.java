package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        Address.class,
                        AddressDTO.class)
                .addMapping(Address::getId, AddressDTO::setId);
    }

    public AddressDTO create(AddressDTO address) {
        var entity = mapper.map(address, Address.class);
        return mapper.map(repository.save(entity), AddressDTO.class);
    }

    public AddressDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, AddressDTO.class);
    }

    public List<AddressDTO> findAll() {
        return repository.findAll().stream()
                .map(address -> {
                    AddressDTO addressDTO = mapper.map(address, AddressDTO.class);
                    addressDTO.add(linkTo(methodOn(AddressController.class).findById(addressDTO.getId())).withSelfRel());
                    return addressDTO;
                })
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Address entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    public AddressDTO update(AddressDTO address) {
        var entity = repository.findById(address.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setStreet(address.getStreet());
        entity.setNumber(address.getNumber());
        entity.setCity(address.getCity());
        entity.setPostalCode(address.getPostalCode());

        var vo =  mapper.map(repository.save(entity), AddressDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }
}
