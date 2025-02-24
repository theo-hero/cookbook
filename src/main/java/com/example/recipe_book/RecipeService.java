package com.example.recipe_book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<String> getAllTags() {
        return recipeRepository.findAllTagNames();
    }
}
