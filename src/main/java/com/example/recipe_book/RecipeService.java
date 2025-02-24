package com.example.recipe_book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipe_book.model.Recipe;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe[]> getAllRecipes() {
        List<Recipe[]> rows = recipeRepository.findAllRecipeDetails();
        return rows;
    }

    public List<String> getAllTags() {
        return recipeRepository.findAllTagNames();
    }

    public List<String> getAllIngredients() {
        return recipeRepository.findAllIngredientNames();
    }

    public List<String> getAllUnits() {
        return recipeRepository.findAllUnitNames();
    }
}
