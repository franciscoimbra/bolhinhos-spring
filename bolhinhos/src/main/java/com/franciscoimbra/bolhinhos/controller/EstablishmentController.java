package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.CustomerOrderDTO;
import com.franciscoimbra.bolhinhos.dto.EstablishmentDTO;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.service.CustomerOrderService;
import com.franciscoimbra.bolhinhos.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establishment/v1")
public class EstablishmentController {
    @Autowired
    private EstablishmentService establishmentService;

    @GetMapping
    public List<EstablishmentDTO> findAll() {
        return establishmentService.findAll();
    }

    @GetMapping("/{id}")
    public EstablishmentDTO findById(@PathVariable("id") Long id) {
        return establishmentService.findById(id);
    }

    @PostMapping
    public EstablishmentDTO create(@RequestBody EstablishmentDTO establishmentDTO) {
        return establishmentService.create(establishmentDTO);
    }

    @PutMapping
    public EstablishmentDTO update(@RequestBody EstablishmentDTO establishmentDTO) {
        return establishmentService.update(establishmentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        establishmentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
