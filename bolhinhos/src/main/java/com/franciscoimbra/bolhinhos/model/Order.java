package com.franciscoimbra.bolhinhos.model;

import com.franciscoimbra.bolhinhos.model.springSecurity.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shipment")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false, length = 20)
    private Date orderDate;

    @Column(name = "pickup_Date", nullable = false, length = 20)
    private Date pickupDate;

    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "id", nullable = false)
    private Address pickupPoint;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order")
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
