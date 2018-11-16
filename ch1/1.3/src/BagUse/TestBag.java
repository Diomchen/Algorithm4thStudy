package BagUse;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Scanner;

public class TestBag {
    public static void main(String[] args) {
        System.out.print("Please input the Num:");
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        Bag<Double> bag = new Bag<>();
        for(int i = 0 ; i<T ; i++ ){
            bag.add(StdRandom.random()*20);
        }
        System.out.println("isEmpty="+bag.isEmpty());
        System.out.println("size="+bag.size());
//        for(int i = 0 ; i<bag.size() ; i++){
//            System.out.println(bag.getbag());
//        }
        for(double b:bag){
            StdOut.printf("%.2f\n",b);
        }


    }
}
