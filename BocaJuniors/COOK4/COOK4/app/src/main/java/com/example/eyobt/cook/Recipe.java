package com.example.eyobt.cook;


import java.util.List;


/**
 * Created by Eyob.T on 2016-12-01.
 */

public class Recipe {
    // instance variables
    String name;
    String steps;
    String foodType;
    String foodCategory;
    int recipePic;
    List<Ingredient> ingredients;

    /**
     * constructor that initializes instance variables
     * @param name of recipe
     * @param foodType of recipe
     * @param foodCategory of recipe
     * @param recipePic of recipe
     * @param ingredients of recipe
     * @param steps of recipe
     */
    public Recipe(String name, String foodType, String foodCategory, int recipePic, List<Ingredient> ingredients, String steps) {
        this.name = name;
        this.foodCategory = foodCategory;
        this.foodType = foodType;
        this.recipePic = recipePic;
        this.ingredients = ingredients;
        this.steps = steps;
    }
}




