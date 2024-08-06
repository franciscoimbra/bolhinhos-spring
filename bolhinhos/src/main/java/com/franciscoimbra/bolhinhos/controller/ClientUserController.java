package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.ClientUserDTO;
import com.franciscoimbra.bolhinhos.service.AddressService;
import com.franciscoimbra.bolhinhos.service.ClientUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientuser/v1")
@Tag(name = "Utilizador", description = "endpoints de utilizador")
public class ClientUserController {
    @Autowired
    private ClientUserService clientUserService;

    @GetMapping
    public List<ClientUserDTO> findAll() {
        return clientUserService.findAll();
    }

    @GetMapping("/{id}")
    public ClientUserDTO findById(@PathVariable("id") Long id) {
        return clientUserService.findById(id);
    }

    @PostMapping
    public ClientUserDTO create(@RequestBody ClientUserDTO clientUserDTO) {
        return clientUserService.create(clientUserDTO);
    }

    @PutMapping
    public ClientUserDTO update(@RequestBody ClientUserDTO clientUserDTO) {
        return clientUserService.update(clientUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        clientUserService.delete(id);
        return ResponseEntity.ok().build();
    }
}
