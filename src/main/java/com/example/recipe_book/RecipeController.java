package com.example.recipe_book;

import com.example.recipe_book.model.Recipe;
import com.example.recipe_book.model.Unit;

//import com.example.recipe_book.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe[]> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/tags")
    public List<String> getAllTags() {
        return recipeService.getAllTags();
    }

    @GetMapping("/ingredients")
    public List<String> getAllIngredients() {
        return recipeService.getAllIngredients();
    }

    @GetMapping("/units")
    public List<String> getAllUnits() {
        return recipeService.getAllUnits();
    }

    @PostMapping("/units")
    public Unit createUnit(@RequestBody Unit unitRequest) {
        return recipeService.createUnit(unitRequest.getName());
    }
}