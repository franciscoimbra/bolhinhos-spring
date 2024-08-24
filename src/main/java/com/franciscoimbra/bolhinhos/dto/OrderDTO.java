package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.Client;
import com.franciscoimbra.bolhinhos.model.Employee;
import com.franciscoimbra.bolhinhos.model.OrderRecipe;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OrderDTO extends RepresentationModel<OrderDTO> implements Serializable {
    private Long id;
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private Address pickupPoint;
    private Employee employee;
    private Client client;
    private List<OrderRecipe> orderRecipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Address getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(Address pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderRecipe> getOrderRecipes() {
        return orderRecipes;
    }

    public void setOrderRecipes(List<OrderRecipe> orderRecipes) {
        this.orderRecipes = orderRecipes;
    }
}
