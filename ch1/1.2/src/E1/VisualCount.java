package E1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.ArrayList;

public class VisualCount {
    private int C = 0;
    private double min = 99999;
    private int m;
    private int n;

    public VisualCount(int N){

        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double data){
        C++;
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.point(C,data);
    }

    public void drawMinLine(ArrayList arr){
        for(int i=0 ; i<arr.size() ; i++){
            for(int j=0 ; j<arr.size() ; j++){
                double k = (Math.abs(j-i)+Math.abs((double)arr.get(j)-(double)arr.get(i)));
                if(i!=j && min>k){
                    min = k;
                    m = j;
                    n = i;
                }
            }
        }
        StdDraw.setPenColor(Color.RED);
        StdDraw.line(m,(double)arr.get(m),n,(double)arr.get(n));
        StdOut.println("MinLine:"+Math.sqrt(Math.pow(m-n,2)+Math.pow(((double)arr.get(m)-(double)arr.get(n)),2)));
    }
}
