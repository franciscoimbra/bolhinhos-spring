package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.ClientUser;
import com.franciscoimbra.bolhinhos.model.Establishment;
import com.franciscoimbra.bolhinhos.model.OrderItem;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

public class CustomerOrderDTO {
    private Long id;
    private Timestamp orderDate;
    private ClientUser client;
    private ClientUser employee;
    private Address deliveryAddress;
    private Establishment pickupLocation;
    private List<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public ClientUser getClient() {
        return client;
    }

    public void setClient(ClientUser client) {
        this.client = client;
    }

    public ClientUser getEmployee() {
        return employee;
    }

    public void setEmployee(ClientUser employee) {
        this.employee = employee;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Establishment getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Establishment pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
