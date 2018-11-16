package FixedCapacityStackOfStringEx;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestFixed {
    public static void main(String[] args) {
        StdOut.println("Please input the caps : ");
        FixedCapacityStackOfString s = new FixedCapacityStackOfString(StdIn.readInt());
        StdOut.println("Please input some string and split by <space>:");
        while(!StdIn.isEmpty()){
            String k = StdIn.readString();
            if(!k.equals("-")){
                s.push(k);
            }
            else if(!s.isEmpty()){
                StdOut.print(s.pop()+" ");
            }
        }
        StdOut.println("( "+ s.size()+ " left on stack" );


    }

}
