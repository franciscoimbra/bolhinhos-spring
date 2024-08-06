package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.ClientUser;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

public class EstablishmentDTO extends RepresentationModel<EstablishmentDTO> implements Serializable {
    private Long id;
    private String name;
    private Address address;
    private List<ClientUser> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ClientUser> getEmployees() {
        return employees;
    }

    public void setEmployees(List<ClientUser> employees) {
        this.employees = employees;
    }
}
