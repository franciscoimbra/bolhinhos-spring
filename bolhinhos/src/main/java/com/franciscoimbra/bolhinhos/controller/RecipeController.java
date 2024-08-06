package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.RecipeDTO;
import com.franciscoimbra.bolhinhos.service.RecipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/v1")
@Tag(name = "Receita", description = "endpoints de receita")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<RecipeDTO> findAll() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public RecipeDTO findById(@PathVariable("id") Long id) {
        return recipeService.findById(id);
    }

    @PostMapping
    public RecipeDTO create(@RequestBody RecipeDTO recipeDTO) {
        return recipeService.create(recipeDTO);
    }

    @PutMapping
    public RecipeDTO update(@RequestBody RecipeDTO recipeDTO) {
        return recipeService.update(recipeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }

}
