    package SelectionSort;

import edu.princeton.cs.algs4.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName: Selection
 * @Description: SelectionSort
 * @Author: DiomChen
 * @Date: 2018/11/30 21:46
 */
public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0 ; i<N ; i++){
            int min = i;
            for(int j = i+1 ; j<N ; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }

            draw(a,i,min);
            try {
                Thread.currentThread();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clear();
            exch(a,i,min);
        }
        successDraw(a);
    }

    public static void successDraw(Comparable[] a){
        int N = a.length;
        draw(a,N,N);
        for(int i=0 ; i<a.length ; i++){
            double x = 1.0*i/N;
            double y = (double)a[i]/2.0;
            double rw = 0.5/N;
            double rh = (double)a[i]/2.0;
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledRectangle(x,y,rw,rh);
            try {
                Thread.currentThread();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void draw(Comparable[] a, int i,int min){
        int N = a.length;
        for(int j=0 ; j<N ; j++){
            double x = 1.0*j/N;
            double y = (double)a[j]/2.0;
            double rw = 0.5/N;
            double rh = (double)a[j]/2.0;
            if(j == min){
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledRectangle(x,y,rw,rh);
            }
            else if(j < i){
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledRectangle(x,y,rw,rh);
            }
            else {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledRectangle(x,y,rw,rh);
            }
        }
    }

    public static void clear(){
        StdDraw.clear();
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i=0 ; i < a.length ; i++){
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1 ; i<a.length ; i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        String [] a = {"A","D","C","B","Z","F","K","G","E"};
//        FileInputStream fis = new FileInputStream(args[0]);
//        System.setIn(fis);
//        String[] a = StdIn.readStrings();
//
//        sort(a);
//        assert isSorted(a);
//        show(a);

        /*
        下面是测试图像的用例
        * */
        int N=50;
        Comparable[] a=new Comparable[N];
        for(int i=0;i<N;i++)
            a[i]= StdRandom.random();
        sort(a);
    }
}
