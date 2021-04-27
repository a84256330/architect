package com.example.lambda.bo;

import lombok.Data;

import java.util.function.Supplier;

@Data
public class Apple {
    private String name;
    private String color;
    private double weight;

    public Apple(String name, String color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public static int compareByWeight(Apple a1, Apple a2) {
        double diff = a1.getWeight() - a2.getWeight();
        return new Double(diff).intValue();
    }

    public String getString(Supplier<String> supplier) {
        return supplier.get();
    }
}
