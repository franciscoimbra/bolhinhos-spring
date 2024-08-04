package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address/v1")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressDTO> findAll() {
        return addressService.getAll();
    }
}
