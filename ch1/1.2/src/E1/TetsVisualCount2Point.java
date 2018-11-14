package E1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Scanner;

public class TetsVisualCount2Point {
    public static void main(String[] args) {
        System.out.print("Please input the Num:");
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        ArrayList<Double> arr = new ArrayList(T);
        VisualCount v = new VisualCount(T);
        for(int i=0 ; i<T ; i++){
            double x = StdRandom.random()*T;
            v.addDataValue(x);
            arr.add(x);
        }
        v.drawMinLine(arr);


    }
}
