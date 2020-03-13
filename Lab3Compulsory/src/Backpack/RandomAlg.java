package Backpack;

import java.util.concurrent.ThreadLocalRandom;

public class RandomAlg implements Algorithm {
    public Knapsack knapsack;
    public AbstractClass[] items;
    public int capacity;
    public int index;
    public AbstractClass[] result;
    public int resultIndex;
    public int resultValue;
    public int resultCapacity;

    public RandomAlg(Knapsack knapsack, AbstractClass[] I) {
        this.knapsack = knapsack;
        this.index=knapsack.getIndex();
        this.capacity=knapsack.getCapacity();
        this.items=new AbstractClass[this.index];
        for(int i=0;i<this.index;i++)
            this.items[i]=I[i];
        this.result=new AbstractClass[index];
        this.resultCapacity=0;
        this.resultIndex=0;
        this.resultValue=0;
    }

    @Override
    public void sortKnapsack() {
        AbstractClass item;
        int flag;
        do{
            flag=0;
            for(int i=0;i<this.items.length-1;i++){
                if(this.items[i].profitFactor()<this.items[i+1].profitFactor()){
                    item=this.items[i];
                    this.items[i]=this.items[i+1];
                    this.items[i+1]=item;
                    flag=1;
                }
                else
                if(this.items[i].profitFactor()==this.items[i+1].profitFactor())
                    if(this.items[i].getValue()<this.items[i+1].getValue()){
                        item=this.items[i];
                        this.items[i]=this.items[i+1];
                        this.items[i+1]=item;
                        flag=1;
                    }
            }
        }
        while(flag==1);
    }

    public int validate(Item I){
        for(int i=0;i<this.result.length;i++)
            if(this.result[i]==I)
                return 1;
        return 0;
    }

    @Override
    public void solve() {
        int randomItem= ThreadLocalRandom.current().nextInt(0, this.index);
        System.out.println("Random generated item: "+randomItem);
        while(this.resultCapacity+this.items[randomItem].getWeight()<=this.capacity){
            if(validate(this.items[randomItem])==0){
                this.result[this.resultIndex++]=this.items[randomItem];
                this.resultCapacity+=this.items[randomItem].getWeight();
            }
            randomItem=ThreadLocalRandom.current().nextInt(0, this.index);
            System.out.println("Random generated item: "+randomItem);
        }
        System.out.println("=========== \nSolution:");
        for(int i=0;i<this.resultIndex;i++){
            System.out.println(this.result[i].toString());
        }
    }
}
