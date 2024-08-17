package com.franciscoimbra.bolhinhos.dto;

import com.franciscoimbra.bolhinhos.model.OrderRecipe;
import com.franciscoimbra.bolhinhos.model.enums.RecipeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

public class RecipeDTO extends RepresentationModel<RecipeDTO> implements Serializable {
    private Long id;
    private String name;
    private RecipeType recipeType;
    private Double price;
    private List<OrderRecipe> orderRecipes;

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

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OrderRecipe> getOrderRecipes() {
        return orderRecipes;
    }

    public void setOrderRecipes(List<OrderRecipe> orderRecipes) {
        this.orderRecipes = orderRecipes;
    }
}
