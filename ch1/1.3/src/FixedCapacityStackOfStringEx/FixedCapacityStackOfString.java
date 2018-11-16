package FixedCapacityStackOfStringEx;

public class FixedCapacityStackOfString {
    private String [] a;
    private int N;
    public FixedCapacityStackOfString(int cap){
        a = new String [cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(String str){
        a[N++] = str;
    }
    public String pop(){
        return a[N--];
    }
}
