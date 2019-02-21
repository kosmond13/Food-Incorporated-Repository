package com.excella.foodinc.write.foodIncWrite.repositories;

import com.excella.foodinc.write.foodIncWrite.domain.FoodNutritionalInformation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodNutritionRepository extends CrudRepository<FoodNutritionalInformation, Long> {
    @Query("SELECT id, name, calories, protein, fat, carbs FROM foodinc.food_nutritional_information fni WHERE LOWER(fni.name) = LOWER(:name)")
    List<FoodNutritionalInformation> findFoodByName(@Param("name") String name);
}