package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.controller.ClientController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.Client;
import com.franciscoimbra.bolhinhos.repository.AddressRepository;
import com.franciscoimbra.bolhinhos.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        Client.class,
                        ClientDTO.class)
                .addMapping(Client::getId, ClientDTO::setId);
    }

    public List<ClientDTO> getClientWithPhone(String phone) {
        return repository.findByPhoneContainingOrNifContaining(phone, phone).stream()
                .map(client -> {
                    ClientDTO clientDTO = mapper.map(client, ClientDTO.class);
                    clientDTO.add(linkTo(methodOn(ClientController.class).findById(clientDTO.getId())).withSelfRel());
                    return clientDTO;
                })
                .collect(Collectors.toList());
    }


    public List<ClientDTO> getAll() {
        return repository.findAll().stream()
                .map(client -> {
                    ClientDTO clientDTO = mapper.map(client, ClientDTO.class);
                    clientDTO.add(linkTo(methodOn(AddressController.class).findById(clientDTO.getId())).withSelfRel());
                    return clientDTO;
                })
                .collect(Collectors.toList());
    }

    public ClientDTO getById(Long id) {
         return mapper.map(repository.findById(id), ClientDTO.class);
    }

    public ClientDTO create(ClientDTO clientDTO) {
        Client cli=repository.save(mapper.map(clientDTO, Client.class));
        return mapper.map(cli, ClientDTO.class);
    }

    public ClientDTO update(ClientDTO clientDTO) {
        var entity = repository.findById(clientDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setEmail(clientDTO.getEmail());
        entity.setFirstName(clientDTO.getFirstName());
        entity.setLastName(clientDTO.getLastName());
        entity.setEmail(clientDTO.getEmail());
        entity.setPhone(clientDTO.getPhone());
        return mapper.map(repository.save(entity), ClientDTO.class);
    }

    public void delete(Long id) {
        Client entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
