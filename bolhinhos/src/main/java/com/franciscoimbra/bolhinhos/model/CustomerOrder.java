package com.franciscoimbra.bolhinhos.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "customer_order")  // Renomear a tabela para evitar conflito
public class CustomerOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Timestamp orderDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientUser client;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private ClientUser employee;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Establishment pickupLocation;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
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