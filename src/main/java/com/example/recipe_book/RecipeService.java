package com.example.recipe_book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipe_book.model.Recipe;
import com.example.recipe_book.model.Unit;
import com.example.recipe_book.repository.UnitRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UnitRepository unitRepository;

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

    public Unit createUnit(String name) {
        Unit unit = new Unit();
        unit.setName(name);
        return unitRepository.save(unit);
    }
}
