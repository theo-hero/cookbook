package com.example.recipe_book;

import com.example.recipe_book.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // @Query(value = "SELECT name FROM tag", nativeQuery = true)
    // List<String> findAllTagNames();

    // @Query(value = "SELECT name FROM ingredient", nativeQuery = true)
    // List<String> findAllIngredientNames();

    // @Query(value = "SELECT name FROM unit", nativeQuery = true)
    // List<String> findAllUnitNames();
}