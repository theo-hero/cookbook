package com.example.recipe_book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.recipe_book.model.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query(value = "SELECT name FROM tag", nativeQuery = true)
    List<String> findAllTagNames(); 

    @Query(value = "SELECT name FROM ingredient", nativeQuery = true)
    List<String> findAllIngredientNames();

    @Query(value = "SELECT name FROM unit", nativeQuery = true)
    List<String> findAllUnitNames();

    @Query(value = "SELECT * FROM recipe_view rv", nativeQuery = true)
    List<Recipe[]> findAllRecipeDetails();
}