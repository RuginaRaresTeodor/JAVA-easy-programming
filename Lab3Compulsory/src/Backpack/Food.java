package Backpack;

import java.util.Objects;

public class Food extends AbstractClass {
    String name;
    int weight;
    int value;

    public Food(String name, int weight, int value) {
        super(name,weight,value);
        System.out.println("\t"+name+", weight= "+weight+", value= "+value);
    }

}