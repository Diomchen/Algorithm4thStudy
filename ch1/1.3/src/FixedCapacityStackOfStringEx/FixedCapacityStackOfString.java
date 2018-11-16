package FixedCapacityStackOfStringEx;

public class FixedCapacityStackOfString {
    private String [] a;
    private int N;
    public FixedCapacityStackOfString(int cap){
        a = new String [cap];
        /*
        * 如果用范型数组的话，最好是这种方式创建泛型数组
        * a = (Item[]) new Object[cap]
        * */

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
