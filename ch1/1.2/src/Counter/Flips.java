package Counter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class Flips {
    public static void main(String[] args) {
        System.out.print("Please input the Num:");
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        Counter c1 = new Counter("heads");
        Counter c2 = new Counter("tails");
        for(int t=0 ; t<T ; t++){
            if(StdRandom.bernoulli(0.5)){
                c1.increment();
            }
            else{
                c2.increment();
            }
        }
        StdOut.println(c1);
        StdOut.println(c2);
        int d = c1.tally()-c2.tally();
        StdOut.println("delta:"+Math.abs(d));
    }
}
