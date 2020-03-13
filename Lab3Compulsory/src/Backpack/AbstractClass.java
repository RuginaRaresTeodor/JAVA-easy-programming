package Backpack;

public class AbstractClass implements Item{
    public String name;
    public int value;
    public int weight;

    public AbstractClass(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    @Override
    public float profitFactor() {
        return (float) (this.value/this.weight);
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString()
    {
        return this.name+ ", " + this.value+ ", "+ this.weight;
    }
}
