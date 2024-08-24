package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Order;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EmployeeDTO extends RepresentationModel<EmployeeDTO> implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdayDay;
    private String email;
    private String phone;
    private LocalDate creationDate;
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

    public LocalDate getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(LocalDate birthdayDay) {
        this.birthdayDay = birthdayDay;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
