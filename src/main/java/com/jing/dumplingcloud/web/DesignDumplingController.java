package com.jing.dumplingcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jing.dumplingcloud.Dumpling;
import com.jing.dumplingcloud.Ingredient;
import com.jing.dumplingcloud.Ingredient.Type;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignDumplingController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("EGRL", "Egg Roll Wrapper", Ingredient.Type.WRAPPER),
                new Ingredient("GYZA", "Gyoza Wrapper", Ingredient.Type.WRAPPER),
                new Ingredient("WTON", "Wonton Wrappers", Ingredient.Type.WRAPPER),
                new Ingredient("BEEF", "Beef", Ingredient.Type.PROTEIN),
                new Ingredient("PORK", "Pork", Ingredient.Type.PROTEIN),
                new Ingredient("CABG", "Cabbage", Ingredient.Type.VEGGIES),
                new Ingredient("SLON", "Sliced Onions", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("VNGR", "Vinegar", Ingredient.Type.SAUCE),
                new Ingredient("SOYS", "Soy Sauce", Ingredient.Type.SAUCE)
        );

        Type[] types = Type.values();

        // Add an attribute with a name of the ingredient type and a list of ingredients of that type
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Dumpling());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Dumpling design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }
}
