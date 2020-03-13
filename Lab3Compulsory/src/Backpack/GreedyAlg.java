package Backpack;

public class GreedyAlg implements Algorithm{
    public Knapsack knapsack;
    public AbstractClass[] items;
    public int capacity;
    public int index;
    public AbstractClass[] result;
    public int resultIndex;
    public int resultValue;
    public int resultCapacity;

    public GreedyAlg(Knapsack knapsack, AbstractClass[] I) {
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

    @Override
    public void solve() {
        for(int i=0;i<this.items.length;i++){
            System.out.println(this.items[i].toString());
            if(this.resultCapacity+this.items[i].getWeight()<=this.capacity){
                this.result[this.resultIndex++]=this.items[i];
                this.resultCapacity+=this.items[i].getWeight();
            }
        }
        for(int i=0;i<this.resultIndex-1;i++){
            System.out.println(this.result[i].toString());
        }
    }
}
