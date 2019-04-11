package com.excella.foodinc.write;

import com.excella.foodinc.write.foodIncWrite.FoodIncWriteApplication;
import com.excella.foodinc.write.foodIncWrite.domains.Food;
import com.excella.foodinc.write.foodIncWrite.resources.FoodController;
import com.sun.tools.javac.util.List;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.excella.foodinc.write.foodIncWrite.services.FoodService;
import org.springframework.test.web.servlet.MvcResult;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(FoodController.class)
@ContextConfiguration(classes = FoodIncWriteApplication.class)
public class FoodControllerTests {

    @MockBean
    FoodService foodService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenViewFoodsPageURL_whenMockMVC_thenReturnsJSON() throws Exception {
        String url = "/nutrition/viewFoods";
        List<Food> expectedFood = List.of(new Food(1, "apple", 95, 0, 0, 95));

        when(foodService.getFoods()).thenReturn(Mono.just(expectedFood));

        MvcResult mvcResult = this.mockMvc.perform(get(url))
                .andExpect(request().asyncStarted())
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"apple\",\"calories\":95,\"fat\":0,\"protein\":0,\"carbs\":95}]"));
    }

    @Test
    public void givenAddPageURL_whenMockMVC_thenPostFood() throws Exception {
        String url = "/nutrition/add";
        JSONObject food = new JSONObject();
        food.put("id", 1);
        food.put("name", "apple");
        food.put("calories", 95);
        food.put("fat", 0);
        food.put("carbs", 95);
        String storeFood = food.toString();

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(storeFood))
                //.andExpect(request().asyncStarted())
                .andExpect(status().isOk())
                .andReturn();
    }
}

