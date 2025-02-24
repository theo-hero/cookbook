package com.example.recipe_book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipe_book.model.Ingredient;
import com.example.recipe_book.model.Recipe;
import com.example.recipe_book.model.RecipeView;
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

    public List<RecipeView[]> getRecipes() {
        List<RecipeView[]> rows = recipeRepository.findRecipes();
        return rows;
    }

    public List<RecipeView[]> getAllRecipes() {
        List<RecipeView[]> rows = recipeRepository.findAllRecipeDetails();
        return rows;
    }

    public RecipeView getRecipeById(Long id) {
        RecipeView recipe = recipeRepository.findRecipeDetailsById(id);
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

    public Recipe createRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setInstruction(recipeDTO.getInstruction());
        recipe.setImageURL(recipeDTO.getImgUrl());

        List<RecipeIngredients> recipeIngredients = new ArrayList<>();
        for (RecipeIngredientDTO ingredientDTO : recipeDTO.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByName(ingredientDTO.getIngredientName())
                    .orElseGet(() -> createIngredient(ingredientDTO.getIngredientName()));

            Unit unit = unitRepository.findByName(ingredientDTO.getUnitName())
                    .orElseThrow(() -> new RuntimeException("Unit not found: " + ingredientDTO.getUnitName()));

            RecipeIngredientId recipeIngredientId = new RecipeIngredientId();
            recipeIngredientId.setRecipeId(recipe.getId());
            recipeIngredientId.setIngredientId(ingredient.getId());

            RecipeIngredients ri = new RecipeIngredients();
            ri.setId(recipeIngredientId);
            ri.setQuantity(ingredientDTO.getQuantity());
            ri.setIngredient(ingredient);
            ri.setUnit(unit);
            ri.setRecipe(recipe);

            recipeIngredients.add(ri);
        }
        recipe.setIngredients(recipeIngredients);

        return recipeRepository.save(recipe);
    }
}
