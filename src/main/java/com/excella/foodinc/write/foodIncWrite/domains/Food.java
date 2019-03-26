package com.excella.foodinc.write.foodIncWrite.domains;

import lombok.*;
import org.springframework.data.annotation.Id;

public class Food{

    @Id
    private int id;

    private String name;

    private int calories;

    private int fat;

    private int protein;

    private int carbs;

    public Food (int id, String name, int calories, int fat, int protein, int carbs) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.carbs = carbs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }
}


