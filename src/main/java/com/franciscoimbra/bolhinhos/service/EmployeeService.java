package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.ClientDTO;
import com.franciscoimbra.bolhinhos.dto.EmployeeDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Employee;
import com.franciscoimbra.bolhinhos.repository.ClientRepository;
import com.franciscoimbra.bolhinhos.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        Employee.class,
                        EmployeeDTO.class)
                .addMapping(Employee::getId, EmployeeDTO::setId);
    }
    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream()
                .map(client -> {
                    EmployeeDTO employeeDTO = mapper.map(client, EmployeeDTO.class);
                    employeeDTO.add(linkTo(methodOn(AddressController.class).findById(employeeDTO.getId())).withSelfRel());
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    public EmployeeDTO getById(Long id) {
        return mapper.map(repository.findById(id), EmployeeDTO.class);
    }

    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        Employee cli=repository.save(mapper.map(employeeDTO, Employee.class));
        return mapper.map(cli, EmployeeDTO.class);
    }

    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        var entity = repository.findById(employeeDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setEmail(employeeDTO.getEmail());
        entity.setFirstName(employeeDTO.getFirstName());
        entity.setLastName(employeeDTO.getLastName());
        entity.setEmail(employeeDTO.getEmail());
        entity.setPhone(employeeDTO.getPhone());
        return mapper.map(repository.save(entity), EmployeeDTO.class);
    }

    public void delete(Long id) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
