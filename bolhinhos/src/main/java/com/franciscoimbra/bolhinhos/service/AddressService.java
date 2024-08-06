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
    AddressRepository addressRepository;

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                        Address.class,
                        AddressDTO.class)
                .addMapping(Address::getId, AddressDTO::setKey);
    }


    public AddressDTO create(AddressDTO address) {
        var entity = mapper.map(address, Address.class);
        var vo = mapper.map(addressRepository.save(entity), AddressDTO.class);
        return vo;
    }

    public List<AddressDTO> findAll() {

        return addressRepository.findAll().stream()
                .map(address -> {
                    AddressDTO addressDTO = mapper.map(address, AddressDTO.class);
                    addressDTO.add(linkTo(methodOn(AddressController.class).findById(addressDTO.getKey())).withSelfRel());
                    return addressDTO;
                })
                .collect(Collectors.toList());
    }

        public AddressDTO findById(Long id) {

        var entity = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, AddressDTO.class);
    }

    public AddressDTO update(AddressDTO addressDTO) {

        var entity = addressRepository.findById(addressDTO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setCity(addressDTO.getCity());
        entity.setCountry(addressDTO.getCountry());
        entity.setState(addressDTO.getState());
        entity.setStreet(addressDTO.getStreet());
        entity.setZipCode(addressDTO.getZipCode());

        var vo =  mapper.map(addressRepository.save(entity), AddressDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        Address entity = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        addressRepository.delete(entity);
    }
}
