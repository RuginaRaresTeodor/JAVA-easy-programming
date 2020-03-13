package Backpack;

public class Weapon extends AbstractClass {
  String name;
  int weight;
  int value;

  public Weapon(String name, int weight, int value) {
    super(name, weight, value);
    System.out.println("\t" + name + ", weight= " + weight + ", value= " + value);
  }
}