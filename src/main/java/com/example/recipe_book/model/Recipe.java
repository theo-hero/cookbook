package com.example.recipe_book.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.recipe_book.RecipeIngredient;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String instruction;
    private String img_url;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RecipeIngredient> ingredients = new ArrayList<>();

    // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    // @JoinTable(
    //     name = "recipe_tags",
    //     joinColumns = @JoinColumn(name = "recipe_id"),
    //     inverseJoinColumns = @JoinColumn(name = "tag_id")
    // )
    // private Set<Tag> tags = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) { 
        this.instruction = instruction;
    }

    public String getImageURL() {
        return img_url;
    }

    public void setImageURL(String img_url) {
        this.img_url = img_url;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    // public Set<Tag> getTags() {
    //     return tags;
    // }

    // public void setTags(Set<Tag> tags) {
    //     this.tags = tags;
    // }
}