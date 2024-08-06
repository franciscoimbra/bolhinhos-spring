package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.RecipeDTO;
import com.franciscoimbra.bolhinhos.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order/v1")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

}
