package Counter;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class Flips {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        Counter c1 = new Counter("heads");
        Counter c2 = new Counter("tails");
        for(int t=0 ; t<T ; t++){
            if(StdRandom.bernoulli(0.5)){

            }
        }
    }
}
