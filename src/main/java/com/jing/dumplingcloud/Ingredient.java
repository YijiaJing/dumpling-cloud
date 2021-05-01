package com.jing.dumplingcloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAPPER, PROTEIN, VEGGIES, CHEESE, SAUCE
    }


}
