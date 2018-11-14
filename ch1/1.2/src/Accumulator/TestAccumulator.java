package Accumulator;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

//累加器 Accumulator
public class TestAccumulator {
    public static void main(String[] args) {
        System.out.print("Please input the Num:");
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        Accumulator a = new Accumulator();
        for(int i=0 ; i<T ; i++){
            a.addDataValue(StdRandom.random());
        }
        StdOut.print(a);
    }
}
