package com.example.recipe_book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipe_book.model.Ingredient;
import com.example.recipe_book.model.Recipe;
import com.example.recipe_book.model.Tag;
import com.example.recipe_book.model.Unit;
import com.example.recipe_book.repository.IngredientRepository;
import com.example.recipe_book.repository.TagRepository;
import com.example.recipe_book.repository.UnitRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Recipe[]> getAllRecipes() {
        List<Recipe[]> rows = recipeRepository.findAllRecipeDetails();
        return rows;
    }

    public Recipe getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findRecipeDetailsById(id);
        return recipe;
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

    public Tag createTag(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        return tagRepository.save(tag);
    }

    public Ingredient createIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        return ingredientRepository.save(ingredient);
    }
}
