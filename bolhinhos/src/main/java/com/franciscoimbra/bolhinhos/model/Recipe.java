package com.franciscoimbra.bolhinhos.model;

import com.franciscoimbra.bolhinhos.model.enums.RecipeType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private RecipeType recipeType;
    private Double price;

    @OneToMany(mappedBy = "recipe")
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
