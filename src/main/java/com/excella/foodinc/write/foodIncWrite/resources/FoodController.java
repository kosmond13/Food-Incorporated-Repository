package com.excella.foodinc.write.foodIncWrite.resources;

import com.excella.foodinc.write.foodIncWrite.domains.Food;
import io.swagger.annotations.ApiOperation;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.excella.foodinc.write.foodIncWrite.services.FoodService;
import com.excella.foodinc.write.foodIncWrite.DTOs.FoodDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/nutrition")
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping(value="/hi", method = RequestMethod.GET)
    @ApiOperation(value = "Find food by name")
    public String showString(){
        return "Hello World";
    }

    @RequestMapping(value="/viewFoods", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieve a list of all foods saved")
    public Publisher<List<Food>> getFoods () {
        return foodService.getFoods();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity saveFood(@RequestBody FoodDTO foodDTO){
        foodService.addFood(foodDTO);
        return new ResponseEntity("Food saved successfully", HttpStatus.OK);

    }
}
