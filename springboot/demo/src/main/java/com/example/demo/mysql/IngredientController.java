package com.example.demo.mysql;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/ingredient") // This means URL's start with /demo (after Application path)
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewIngredient(@RequestBody IngredientRequestModel ingredient) {
        Ingredient i = new Ingredient();
        BeanUtils.copyProperties(ingredient, i, "recipeID");
        ingredientRepository.save(i);
        return "Saved " + i.toString();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ingredient> getAllIngredients() {
        // This returns a JSON or XML with the users
        return ingredientRepository.findAll();
    }
}