package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.repository.AddressRepository;
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
    private EstablishmentRepository establishmentRepository;

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                        Establishment.class,
                        AddressDTO.class)
                .addMapping(Establishment::getId, AddressDTO::setKey);
    }

    public EstablishmentDTO create(EstablishmentDTO address) {
        var entity = mapper.map(address, Establishment.class);
        var vo = mapper.map(establishmentRepository.save(entity), EstablishmentDTO.class);
        return vo;
    }

    public List<EstablishmentDTO> findAll() {

        return establishmentRepository.findAll().stream()
                .map(address -> {
                    EstablishmentDTO establishmentDTO = mapper.map(address, EstablishmentDTO.class);
                    establishmentDTO.add(linkTo(methodOn(AddressController.class).findById(establishmentDTO.getId())).withSelfRel());
                    return establishmentDTO;
                })
                .collect(Collectors.toList());
    }

    public EstablishmentDTO findById(Long id) {

        var entity = establishmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, EstablishmentDTO.class);
    }

    public EstablishmentDTO update(EstablishmentDTO establishmentDTO) {

        var entity = establishmentRepository.findById(establishmentDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

       entity.setName(establishmentDTO.getName());


        var vo =  mapper.map(establishmentRepository.save(entity), EstablishmentDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        Establishment entity = establishmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        establishmentRepository.delete(entity);
    }
}
