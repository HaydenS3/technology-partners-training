package com.example.demo.mysql;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/recipe")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private StepRepository stepRepository;

    // Do we have to worry about SQL injection here?

    @PostMapping(path = "/add")
    public @ResponseBody String addNewRecipe(@RequestBody RecipeRequestModel recipe) {
        Recipe r = new Recipe();
        BeanUtils.copyProperties(recipe, r);
        recipeRepository.save(r);
        return "Saved: " + r.toString();
    }

    @PostMapping(path = "/linkingredient")
    public @ResponseBody String linkIngredient(@RequestParam Long recipeID, @RequestParam Long ingredientID) {
        Recipe r = recipeRepository.getById(recipeID);
        Ingredient i = ingredientRepository.getById(ingredientID);
        r.addIngredient(i);
        i.addRecipe(r);
        recipeRepository.save(r);
        ingredientRepository.save(i);
        return "Linked " + i.toString() + " to " + r.toString();
    }

    @PostMapping(path = "/linkstep")
    public @ResponseBody String linkStep(@RequestParam Long recipeID, @RequestParam Long stepID) {
        Recipe r = recipeRepository.getById(recipeID);
        Step s = stepRepository.getById(stepID);
        r.addStep(s);
        s.addRecipe(r);
        recipeRepository.save(r);
        stepRepository.save(s);
        return "Linked " + s.toString() + " to " + r.toString();
    }

    @PostMapping(path = "/addingredient")
    public @ResponseBody String addIngredient(@RequestBody IngredientRequestModel ingredient) {
        Recipe r = recipeRepository.getById(ingredient.getRecipeID());
        Ingredient i = new Ingredient();
        BeanUtils.copyProperties(ingredient, i, "recipeID");
        ingredientRepository.save(i);
        r.addIngredient(i);
        i.addRecipe(r);
        recipeRepository.save(r);
        return "Added " + i.toString() + " to " + r.toString();
    }

    @PostMapping(path = "/addstep")
    public @ResponseBody String addStep(@RequestBody StepRequestModel step) {
        Recipe r = recipeRepository.getById(step.getRecipeID());
        Step s = new Step();
        BeanUtils.copyProperties(step, s, "recipeID");
        stepRepository.save(s);
        r.addStep(s);
        s.addRecipe(r);
        recipeRepository.save(r);
        return "Added " + s.toString() + " to " + r.toString();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}