package com.excella.foodinc.write.foodIncWrite.controllers.implementation;

import com.excella.foodinc.write.foodIncWrite.domain.FoodNutritionalInformation;
import com.excella.foodinc.write.foodIncWrite.models.FoodDto;
import com.excella.foodinc.write.foodIncWrite.controllers.FoodWriteController;
import com.excella.foodinc.write.foodIncWrite.repositories.FoodNutritionRepository;
import com.excella.foodinc.write.foodIncWrite.services.FoodWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
@Service
public class FoodWriteControllerImpl implements FoodWriteController {

    @Autowired
    FoodNutritionRepository foodNutritionRepository;
    @Autowired
    FoodWriteService foodService;
    @GetMapping("/nutrition")
    public String testValue(){
        String returnValue = "this is a test";
        return returnValue;
    }
    @GetMapping("/nutrition/test")
    public List<FoodNutritionalInformation> getFoodByName(@RequestParam(value="food", required = false)String food){
        System.out.println("return value is " + foodNutritionRepository.findFoodByName(food));
        return foodNutritionRepository.findFoodByName(food);
    }
}

