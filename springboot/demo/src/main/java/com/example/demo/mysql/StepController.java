package com.example.demo.mysql;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/step")
public class StepController {
    @Autowired
    StepRepository stepRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewStep(@RequestBody StepRequestModel step) {
        Step s = new Step();
        BeanUtils.copyProperties(step, s, "recipeID");
        stepRepository.save(s);
        return "Saved: " + s.toString();
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Step> getAllSteps() {
        return stepRepository.findAll();
    }
}
