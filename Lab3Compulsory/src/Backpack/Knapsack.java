package Backpack;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Knapsack {
  public int capacity;
  public static AbstractClass[] items;
  public int index;

  public Knapsack(int capacity) {
    this.capacity = capacity;
    items = new AbstractClass[capacity];
    index = 0;
  }


  public int getIndex() {
    return this.index;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void add(AbstractClass... I) {
    for (int i = 0; i < I.length; i++) this.items[this.index++] = I[i];
  }

  @Override
  public String toString() {
    String total = new String();
    for (int i = 0; i < this.index; i++) total = total + this.items[i].toString() + "\n";
    return total;
  }

  public void display() {
    if (items != null && items.length > 0) {
      System.out.println("capacity of the knapsack = " + capacity);
    }
  }
  public static void main(String[] args) {
    Knapsack knapsack=new Knapsack(10);
    knapsack.display();

    System.out.println("Available items:");
    Book book1=new Book("Dragon Rising", 3,5);
    Book book2=new Book("A blade in the dark",2,5);
    Food food1=new Food("Cabbage",2,4);
    Food food2=new Food("Rabbit",2,4);
    Weapon weapon=new Weapon("Sword",5,10);

    System.out.print("\n");
    knapsack.add(book1, book2);
    knapsack.add(food1,food2);
    knapsack.add(weapon);
    Algorithm randomA=new RandomAlg(knapsack, items);
    Algorithm greedyA=new GreedyAlg(knapsack, items);
    Algorithm dynamicA=new DynamicAlg(knapsack,items);

    dynamicA.solve();
    System.out.println("----------------------------   Dynamic Algorithm is done!");

    greedyA.sortKnapsack();
    greedyA.solve();
    System.out.println("----------------------------   Greedy Algorithm is done!");

    randomA.sortKnapsack();
    randomA.solve();
    System.out.println("----------------------------   Random Algorithm is done!");
  }

}
