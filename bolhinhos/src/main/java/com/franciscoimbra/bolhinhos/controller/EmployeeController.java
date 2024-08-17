package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.ClientDTO;
import com.franciscoimbra.bolhinhos.dto.EmployeeDTO;
import com.franciscoimbra.bolhinhos.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee/v1")
@Tag(name = "Funcionário", description = "endpoints da Funcionário")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) {
        return service.getById(id);
    }
    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return service.create(employeeDTO);
    }
    @PutMapping
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO) {
        return service.update(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
