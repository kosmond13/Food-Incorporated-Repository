package com.excella.foodinc.write.foodIncWrite.services;

import reactor.core.publisher.Mono;
import com.excella.foodinc.write.foodIncWrite.models.FoodDto;

public interface FoodWriteService {
    Mono<FoodDto> getNutrition(String foodItem);
}