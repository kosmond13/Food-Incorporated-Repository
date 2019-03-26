package com.excella.foodinc.write.foodIncWrite.services;

import com.excella.foodinc.write.foodIncWrite.domains.Food;
import com.excella.foodinc.write.foodIncWrite.repository.FoodRepository;
import com.excella.foodinc.write.foodIncWrite.DTOs.FoodDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void addFood(FoodDTO foodDTO){

        Food food = new Food(0, "NA", 0, 0, 0, 0);
        food = mapToFood(foodDTO, food);
        foodRepository.save(food);
    }

    public Mono<List<Food>> getFoods(){
        List<Food> foodList = (List<Food>)foodRepository.findAll();
        return Mono.just(foodList);
    }

    public Food mapToFood(FoodDTO foodDTO, Food food) {
        food.setId(foodDTO.getId());
        food.setName(foodDTO.getName());
        food.setCalories(foodDTO.getCalories());
        food.setCarbs(foodDTO.getCalories());
        food.setFat(foodDTO.getFat());
        food.setProtein(foodDTO.getProtein());
        return food;
    }
}
