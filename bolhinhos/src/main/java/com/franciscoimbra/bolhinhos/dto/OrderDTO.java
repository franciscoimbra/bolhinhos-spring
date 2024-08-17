package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.Client;
import com.franciscoimbra.bolhinhos.model.Employee;
import com.franciscoimbra.bolhinhos.model.OrderRecipe;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDTO extends RepresentationModel<OrderDTO> implements Serializable {
    private Long id;
    private Date orderDate;
    private Date pickupDate;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
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
