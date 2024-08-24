package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Address;
import com.franciscoimbra.bolhinhos.model.Order;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ClientDTO extends RepresentationModel<ClientDTO> implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthdayDay;
    private String nif;
    private String email;
    private String phone;
    private Date creationDate;
    private List<Address> addressList;
    private List<Order> orderList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(Date birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
