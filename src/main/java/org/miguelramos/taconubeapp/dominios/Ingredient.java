package org.miguelramos.taconubeapp.dominios;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Ingredient;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
