package Counter;

import edu.princeton.cs.algs4.Count;

public class Counter {
    private String id;
    private int count;
    public Counter(String id){
        this.id = id;
        count = 0;
    }

    public void increment(){
        count++;
    }

    public String toString(){
        return count+" "+id;
    }
}
