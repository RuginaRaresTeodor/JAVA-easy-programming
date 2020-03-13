package Backpack;

import java.util.List;

public class DynamicAlg implements Algorithm {
    public Knapsack knapsack;
    public AbstractClass[] items;
    public int capacity;
    public int index;
    public int resultIndex;
    public int resultValue;
    public int resultCapacity;
    public AbstractClass[] result;


    public DynamicAlg(Knapsack knapsack, AbstractClass[] I) {
        this.knapsack = knapsack;
        this.index = knapsack.getIndex();
        this.capacity = knapsack.getCapacity();
        this.items = new AbstractClass[this.index];
        for (int i = 0; i < this.index; i++)
            this.items[i] = I[i];
        this.result = new AbstractClass[index];
        this.resultCapacity = 0;
        this.resultIndex = 0;
        this.resultValue = 0;
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

    @Override
    public void solve() {
        int[][] matrix=new int[this.items.length+1][this.capacity+1];
        for(int i=0;i<=this.capacity;i++)
            matrix[0][i]=0;
        for(int i=1;i<this.items.length;i++){
            for(int j=1;j<=this.capacity;j++){
                if(this.items[i-1].getWeight()<=j)
                    matrix[i][j]=Math.max(this.items[i-1].getValue()+matrix[i-1][j-this.items[i-1].getWeight()], matrix[i-1][j]);
                else
                    matrix[i][j]=matrix[i-1][j];
            }
        }
        for(int[] rows:matrix){
            for(int col:rows){
                System.out.format("%5d",col);
            }
            System.out.println();
        }
    }
}
