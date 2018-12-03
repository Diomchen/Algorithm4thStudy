package SortCompare;

import SelectionSort.Selection;
import ShellSort.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import insertSort.Insertion;

/**
 * @ClassName: SC
 * @Description: TODO
 * @Author: DiomChen
 * @Date: 2018/12/3 12:43
 */
public class SC {
    public static double time(String alg,Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")){
            Insertion.sort(a);
        }
        if(alg.equals("Selection")){
            Selection.sort(a);
        }
        if(alg.equals("Shell")){
            Shell.sort(a);
        }
        return timer.elapsedTime();

//        if(alg.equals("InsertSort")){
//            Insertion.sort(a);
//        }
//        if(alg.equals("InsertSort")){
//            Insertion.sort(a);
//        }
//        if(alg.equals("InsertSort")){
//            Insertion.sort(a);
//        }
//        if(alg.equals("InsertSort")){
//            Insertion.sort(a);
//        }
//
    }

    public static double timerRandomInput(String alg,int N,int T){
        double total = 0.0;
        Double []a = new Double[N];
        for(int t=0 ; t<T ; t++){
            for(int i=0 ; i<N ; i++){
                a[i] = StdRandom.uniform();
            }
            total+=time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Shell";
        int N = Integer.parseInt("1000");
        int T = Integer.parseInt("100");
        double t1 = timerRandomInput(alg1,N,T);
        double t2 = timerRandomInput(alg2,N,T);
        StdOut.println("N: "+ N+ " alg1: "+alg1 + " alg2: "+alg2);
        StdOut.printf("times: %.1f alg1Time: %.8f alg2Time: %.8f",t2/t1,t1,t2);
    }

}
