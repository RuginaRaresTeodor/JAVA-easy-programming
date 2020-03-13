package Backpack;

import java.util.Objects;

public class Book extends AbstractClass{
    public Book(String name, int weight, int value) {
        super(name,weight,value);
        System.out.println("\t"+name+", weight= "+weight+", value= "+value);
    }
}
