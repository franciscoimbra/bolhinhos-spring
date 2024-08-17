package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.Order;
import com.franciscoimbra.bolhinhos.model.Recipe;
import com.franciscoimbra.bolhinhos.model.enums.OrderStatus;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class OrderRecipeDTO extends RepresentationModel<OrderRecipeDTO> implements Serializable {
    private Long id;
    private Order order;
    private Recipe recipe;
    private int quantity;
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
