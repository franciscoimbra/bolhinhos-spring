package com.franciscoimbra.bolhinhos.repository;

import com.franciscoimbra.bolhinhos.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
