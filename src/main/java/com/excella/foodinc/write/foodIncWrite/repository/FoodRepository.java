package com.excella.foodinc.write.foodIncWrite.repository;

import com.excella.foodinc.write.foodIncWrite.domains.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

}
