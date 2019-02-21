package com.excella.foodinc.write.foodIncWrite.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

@JsonSerialize
public class FoodDto {
    public String name;
    public int calories;
    public int protein;
    public int fat;
    public int carbs;

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

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) { this.fat = fat; }

    public int getCarbs() {return carbs;}

    public void setCarbs(int carbs){this.carbs = carbs;}

    public FoodDto(String name, int calories, int protein, int fat, int carbs) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodDto foodDto = (FoodDto) o;
        return calories == foodDto.calories &&
                protein == foodDto.protein &&
                fat == foodDto.fat &&
                carbs == foodDto.carbs &&
                Objects.equals(name, foodDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories, protein, fat, carbs);
    }
}