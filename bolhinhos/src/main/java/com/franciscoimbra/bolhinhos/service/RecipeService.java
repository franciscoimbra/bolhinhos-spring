package com.franciscoimbra.bolhinhos.service;

import com.franciscoimbra.bolhinhos.controller.AddressController;
import com.franciscoimbra.bolhinhos.dto.AddressDTO;
import com.franciscoimbra.bolhinhos.dto.RecipeDTO;
import com.franciscoimbra.bolhinhos.exception.ResourceNotFoundException;
import com.franciscoimbra.bolhinhos.model.Recipe;
import com.franciscoimbra.bolhinhos.repository.AddressRepository;
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
    private RecipeRepository recipeRepository;

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                        Recipe.class,
                        RecipeDTO.class)
                .addMapping(Recipe::getId, RecipeDTO::setId);
    }


    public RecipeDTO create(RecipeDTO recipe) {
        var entity = mapper.map(recipe, Recipe.class);
        var vo = mapper.map(recipeRepository.save(entity), RecipeDTO.class);
        return vo;
    }

    public List<RecipeDTO> findAll() {

        return recipeRepository.findAll().stream()
                .map(recipe -> {
                    RecipeDTO recipeDTO = mapper.map(recipe, RecipeDTO.class);
                    recipeDTO.add(linkTo(methodOn(AddressController.class).findById(recipeDTO.getId())).withSelfRel());
                    return recipeDTO;
                })
                .collect(Collectors.toList());
    }

    public RecipeDTO findById(Long id) {

        var entity = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return mapper.map(entity, RecipeDTO.class);
    }

    public RecipeDTO update(RecipeDTO recipeDTO) {

        var entity = recipeRepository.findById(recipeDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(recipeDTO.getName());
        entity.setPrice(recipeDTO.getPrice());
        entity.setRecipeType(recipeDTO.getRecipeType());

        var vo =  mapper.map(recipeRepository.save(entity), RecipeDTO.class);
        vo.add(linkTo(methodOn(AddressController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        Recipe entity = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        recipeRepository.delete(entity);
    }
}
