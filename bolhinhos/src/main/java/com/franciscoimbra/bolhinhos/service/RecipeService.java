package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.RecipeDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Recipe;
import com.franciscoimbra.bolhinhos.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    private static final ModelMapper mapper = new ModelMapper();
    static {
        mapper.createTypeMap(
                        Recipe.class,
                        RecipeDTO.class)
                .addMapping(Recipe::getId, RecipeDTO::setId);
    }

    public RecipeDTO create(RecipeDTO recipe) {
        var entity = mapper.map(recipe, Recipe.class);
        return mapper.map(repository.save(entity), RecipeDTO.class);
    }

    public RecipeDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, RecipeDTO.class);
    }

    public List<RecipeDTO> findAll() {
        return repository.findAll().stream()
                .map(recipe -> {
                    RecipeDTO recipeDTO = mapper.map(recipe, RecipeDTO.class);
                    recipeDTO.add(linkTo(methodOn(AddressController.class).findById(recipeDTO.getId())).withSelfRel());
                    return recipeDTO;
                })
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Recipe entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    public RecipeDTO update(RecipeDTO recipe) {
        var entity = repository.findById(recipe.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(recipe.getName());
        entity.setPrice(recipe.getPrice());
        entity.setRecipeType(recipe.getRecipeType());

        var vo =  mapper.map(repository.save(entity), RecipeDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }
}

