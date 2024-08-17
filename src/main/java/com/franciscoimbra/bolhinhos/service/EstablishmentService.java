package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientDTO;
import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.model.Client;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.repository.EstablishmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EstablishmentService {
    @Autowired
    EstablishmentRepository repository;

    public EstablishmentService(EstablishmentRepository repository) {
        this.repository = repository;
    }

    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        Establishment.class,
                        EstablishmentDTO.class)
                .addMapping(Establishment::getId, EstablishmentDTO::setId);
    }

    public EstablishmentDTO create(EstablishmentDTO establishment) {
        var entity = mapper.map(establishment, Establishment.class);
        return mapper.map(repository.save(entity), EstablishmentDTO.class);
    }

    public EstablishmentDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, EstablishmentDTO.class);
    }

    public List<EstablishmentDTO> findAll() {
        return repository.findAll().stream()
                .map(establishment -> {
                    EstablishmentDTO establishmentDTO = mapper.map(establishment, EstablishmentDTO.class);
                    establishmentDTO.add(linkTo(methodOn(AddressController.class).findById(establishmentDTO.getId())).withSelfRel());
                    return establishmentDTO;
                })
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Establishment entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    public EstablishmentDTO update(EstablishmentDTO establishment) {
        var entity = repository.findById(establishment.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAddress(establishment.getAddress());
        entity.setEmail(establishment.getEmail());
        entity.setName(establishment.getName());
        entity.setPhone(establishment.getPhone());

        var vo =  mapper.map(repository.save(entity), EstablishmentDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }


}
