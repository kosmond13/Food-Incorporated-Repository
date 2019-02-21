package com.excella.foodinc.write.foodIncWrite.controllers;

import com.excella.foodinc.write.foodIncWrite.domain.FoodNutritionalInformation;
import com.excella.foodinc.write.foodIncWrite.models.FoodDto;
import reactor.core.publisher.Mono;
import java.util.List;

public interface FoodWriteController {

    Mono<FoodDto>getNutritionData(String recipe);
    List<FoodNutritionalInformation> getFoodByName(String food);
}