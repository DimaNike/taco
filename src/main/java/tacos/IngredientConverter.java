package tacos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.data.IngredientRepository;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String source) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getId().equals(source))
                return ingredient;
        }
        return null;
    }
}
