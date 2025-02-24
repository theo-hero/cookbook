package com.example.recipe_book;

import com.example.recipe_book.model.Recipe;
import com.example.recipe_book.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    // @GetMapping
    // public List<Recipe> getAllRecipes() {
    //     return recipeRepository.findAll();
    // }

    @GetMapping("/tags")
    public List<String> getAllTags() {
        return recipeService.getAllTags();
    }
}