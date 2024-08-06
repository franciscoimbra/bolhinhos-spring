package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientUserDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.ClientUser;
import com.franciscoimbra.bolhinhos.repository.AddressRepository;
import com.franciscoimbra.bolhinhos.repository.ClientUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClientUserService {
    @Autowired
    ClientUserRepository clientUserRepository;
    private static ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        ClientUser.class,
                        ClientUserDTO.class)
                .addMapping(ClientUser::getId, ClientUserDTO::setId);
    }
    public ClientUserDTO create(ClientUserDTO address) {
        var entity = mapper.map(address, ClientUser.class);
        var vo = mapper.map(clientUserRepository.save(entity), ClientUserDTO.class);
        return vo;
    }
    public List<ClientUserDTO> findAll() {
        return clientUserRepository.findAll().stream()
                .map(address -> {
                    ClientUserDTO clientUserDTO = mapper.map(address, ClientUserDTO.class);
                    clientUserDTO.add(linkTo(methodOn(AddressController.class).findById(clientUserDTO.getId())).withSelfRel());
                    return clientUserDTO;
                })
                .collect(Collectors.toList());
    }
    public ClientUserDTO findById(Long id) {

        var entity = clientUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, ClientUserDTO.class);
    }
    public ClientUserDTO update(ClientUserDTO clientUserDTO) {
        var entity = clientUserRepository.findById(clientUserDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setBirthday(clientUserDTO.getBirthday());
        entity.setEmail(clientUserDTO.getEmail());
        entity.setFirstName(clientUserDTO.getFirstName());
        entity.setNif(clientUserDTO.getNif());
        entity.setLastName(clientUserDTO.getLastName());
        entity.setPhone(clientUserDTO.getPhone());
        entity.setRole(clientUserDTO.getRole());
        var vo =  mapper.map(clientUserRepository.save(entity), ClientUserDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }
    public void delete(Long id) {
        ClientUser entity = clientUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        clientUserRepository.delete(entity);
    }
}

