package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/establishment/v1")
public class EstablishmentController {
    @Autowired
    private EstablishmentService establishmentService;


}
