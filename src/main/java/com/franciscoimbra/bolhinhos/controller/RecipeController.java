package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.OrderRecipeDTO;
import com.franciscoimbra.bolhinhos.dto.RecipeDTO;
import com.franciscoimbra.bolhinhos.service.OrderRecipeService;
import com.franciscoimbra.bolhinhos.service.RecipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe/v1")
@Tag(name = "Recipe", description = "endpoints da Recipe")
public class RecipeController {
    @Autowired
    RecipeService service ;

    @GetMapping
    public List<RecipeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RecipeDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
    @PostMapping
    public RecipeDTO create(@RequestBody RecipeDTO recipeDTO) {
        return service.create(recipeDTO);
    }
    @PutMapping
    public RecipeDTO update(@RequestBody RecipeDTO recipeDTO) {
        return service.update(recipeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
