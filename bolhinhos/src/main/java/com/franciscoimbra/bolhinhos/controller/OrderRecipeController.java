package com.franciscoimbra.bolhinhos.controller;

import com.franciscoimbra.bolhinhos.dto.OrderDTO;
import com.franciscoimbra.bolhinhos.dto.OrderRecipeDTO;
import com.franciscoimbra.bolhinhos.service.OrderRecipeService;
import com.franciscoimbra.bolhinhos.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-recipe/v1")
@Tag(name = "OrderRecipe", description = "endpoints da OrderRecipe")
public class OrderRecipeController {
    @Autowired
    OrderRecipeService service ;

    @GetMapping
    public List<OrderRecipeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderRecipeDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
    @PostMapping
    public OrderRecipeDTO create(@RequestBody OrderRecipeDTO orderRecipeDTO) {
        return service.create(orderRecipeDTO);
    }
    @PutMapping
    public OrderRecipeDTO update(@RequestBody OrderRecipeDTO orderRecipeDTO) {
        return service.update(orderRecipeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
