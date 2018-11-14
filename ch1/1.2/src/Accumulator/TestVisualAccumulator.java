package Accumulator;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class TestVisualAccumulator {
    public static void main(String[] args) {
        System.out.print("Please input the Num:");
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        VisualAccumulator a = new VisualAccumulator(T , 1.0);
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }

}