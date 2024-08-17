package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.EmployeeDTO;
import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.service.EmployeeService;
import com.franciscoimbra.bolhinhos.service.EstablishmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establishment/v1")
@Tag(name = "Estabelecimento", description = "endpoints da Estabelecimento")
public class EstablishmentController {


    @Autowired
    EstablishmentService service;

    @GetMapping
    public List<EstablishmentDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EstablishmentDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
    @PostMapping
    public EstablishmentDTO create(@RequestBody EstablishmentDTO establishmentDTO) {
        return service.create(establishmentDTO);
    }
    @PutMapping
    public EstablishmentDTO update(@RequestBody EstablishmentDTO establishmentDTO) {
        return service.update(establishmentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
