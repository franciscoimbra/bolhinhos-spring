package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.ClientUserDTO;
import com.franciscoimbra.bolhinhos.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientuser/v1")
public class ClientUserController {
    @Autowired
    private ClientUserService clientUserService;

    @GetMapping
    public List<ClientUserDTO> getClientUsers() {
        return clientUserService.findAll();
    }
}
