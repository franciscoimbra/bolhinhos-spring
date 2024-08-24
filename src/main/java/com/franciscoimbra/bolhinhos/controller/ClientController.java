package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientDTO;
import com.franciscoimbra.bolhinhos.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/v1")
@Tag(name = "Cliente", description = "endpoints da Cliente")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping
    public List<ClientDTO> findAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable("id") Long id) {
        return  service.getById(id);
    }
    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO clientDTO) {
        return service.create(clientDTO);
    }
    @PutMapping
    public ClientDTO update(@RequestBody ClientDTO clientDTO) {
        return service.update(clientDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/filter/{nifOrPhone}")
    public List<ClientDTO> findAllAddresses(@PathVariable("nifOrPhone") String nifOrPhone) {return service.getClientWithPhone(nifOrPhone);}


}
